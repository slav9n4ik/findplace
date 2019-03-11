package ru.findplace.demo.service.user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.findplace.demo.Dtos.UserRegistrationDto;
import ru.findplace.demo.Dtos.mailchimp.campaignbooklist.Member;
import ru.findplace.demo.Dtos.mailchimp.campaignbooklist.MergeFields;
import ru.findplace.demo.entity.Interest;
import ru.findplace.demo.entity.Role;
import ru.findplace.demo.entity.User;
import ru.findplace.demo.repository.InterestRrepository;
import ru.findplace.demo.repository.UserRepository;
import ru.findplace.demo.service.member.MemberService;

import java.util.*;

@Service
public class UserServiceImpl implements UserService {

    Logger LOG = LoggerFactory.getLogger(UserServiceImpl.class);

    private final UserRepository userRepository;
    private final InterestRrepository interestRrepository;
    private final MemberService memberService;
    public static final PasswordEncoder PASSWORD_ENCODER = new BCryptPasswordEncoder();

    @Autowired
    public UserServiceImpl(UserRepository userRepository, InterestRrepository interestRrepository, MemberService memberService) {
        this.userRepository = userRepository;
        this.interestRrepository = interestRrepository;
        this.memberService = memberService;
    }

    @Override
    public User save(UserRegistrationDto registration, List<String> interestValues) {
        User user = new User();
        user.setName(registration.getName());
        user.setEmail(registration.getEmail());
        user.setPhone(registration.getPhone());
        user.setPassword(registration.getPassword());
        user.setRoles(new HashSet<>(Collections.singleton(Role.USER)));
        setInterests(user, interestValues);
        setInterestsInMemberGroups(user);
        return userRepository.save(user);
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Transactional(readOnly = true)
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        LOG.info("Fetching user " + email);
        User user = userRepository.findByEmail(email);
        if (user == null) {
            throw new UsernameNotFoundException(email);
        }
        LOG.info("Transforming " + user + " into UserDetails object");
        List<String> roles = new ArrayList<>();
        user.getRoles().forEach(r -> roles.add(r.getAuthority()));
        String[] strRoles = Arrays.copyOf(roles.toArray(), roles.size(), String[].class);
        UserDetails userDetails = new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(),
                AuthorityUtils.createAuthorityList(strRoles));
        LOG.info("About to return " + userDetails);
        return userDetails;
    }

    private void setInterests(User user, List<String> interestValues) {
        Set<Interest> interests = new HashSet<>();
        for (String name: interestValues) {
            Interest i = interestRrepository.findFirstByName(name);
            interests.add(i);
        }
        user.setInterests(interests);
    }

    private void setInterestsInMemberGroups(User user) {
        for (Interest i : user.getInterests()) {
            Interest responseInterest = interestRrepository.findFirstByName(i.getName());
            if (responseInterest != null) {
                subscribeUser(responseInterest, user);
            }
        }
    }

    private void subscribeUser(Interest i, User user) {
        MergeFields mergeFields = new MergeFields();
        mergeFields.setFNAME(user.getName());
        mergeFields.setPHONE(user.getPhone());

        Member member = new Member();
        member.setMergeFields(mergeFields);
        member.setEmailAddress(user.getEmail());
        member.setStatus("subscribed");

        memberService.addMemberByListName(i.getName(),member);
    }
}
