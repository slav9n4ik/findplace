package ru.findplace.demo.service.registration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.findplace.demo.Dtos.mailchimp.campaignbooklist.Member;
import ru.findplace.demo.Dtos.mailchimp.campaignbooklist.MergeFields;
import ru.findplace.demo.entity.Interest;
import ru.findplace.demo.entity.User;
import ru.findplace.demo.repository.InterestRrepository;
import ru.findplace.demo.repository.UserRepository;
import ru.findplace.demo.service.member.MemberService;

import java.util.HashSet;
import java.util.Set;

@Service
public class RegistrationServiceImpl implements RegistrationService {

    private final UserRepository userRepository;
    private final InterestRrepository interestRrepository;
    private final MemberService memberService;

    @Autowired
    public RegistrationServiceImpl(UserRepository userRepository, InterestRrepository interestRrepository, MemberService memberService) {
        this.userRepository = userRepository;
        this.interestRrepository = interestRrepository;
        this.memberService = memberService;
    }

    @Override
    public boolean addUser(User userRequestDto) {
        User user = userRepository.findFirstByEmail(userRequestDto.getEmail());
        if (user != null) {
            return false;
        }
        userRequestDto.setInterests(getInterestsIds(userRequestDto));
        userRepository.save(userRequestDto);
        return true;
    }

    private Set<Interest> getInterestsIds(User userRequestDto) {
        Set<Interest> ids = new HashSet<>();
        for (Interest i : userRequestDto.getInterests()) {
            Interest responseInterest = interestRrepository.findFirstByName(i.getName());
            if (responseInterest != null) {
                ids.add(responseInterest);
                subscribeUser(responseInterest, userRequestDto);
            }
        }
        return ids;
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
