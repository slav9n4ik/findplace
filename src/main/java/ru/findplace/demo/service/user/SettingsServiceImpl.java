package ru.findplace.demo.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import ru.findplace.demo.Dtos.UpdateUserDto;
import ru.findplace.demo.entity.Interest;
import ru.findplace.demo.entity.User;
import ru.findplace.demo.repository.InterestRepository;
import ru.findplace.demo.repository.UserRepository;
import ru.findplace.demo.utils.CurrentUser;

import java.util.Set;

@Service
public class SettingsServiceImpl implements SettingsService {

    private final UserRepository userRepository;
    private final InterestRepository interestRepository;
    private final UserServiceImpl userService;

    @Autowired
    public SettingsServiceImpl(UserRepository userRepository, InterestRepository interestRepository, UserServiceImpl userService) {
        this.userRepository = userRepository;
        this.interestRepository = interestRepository;
        this.userService = userService;
    }

    @Override
    public Set<Interest> putUserInterest(String interestName) {
        Interest interest = interestRepository.findFirstByName(interestName);
        User user = userRepository.findByEmail(CurrentUser.getEmail());
        Set<Interest> set = user.getInterests();
        if(!set.contains(interest)) {
            set.add(interest);
            user.setInterests(set);
            userService.subscribeUser(interest, user);
            userRepository.save(user);
        }
        return set;
    }

    @Override
    public Set<Interest> deleteUserInterest(String interestName) {
        Interest interest = interestRepository.findFirstByName(interestName);
        User user = userRepository.findByEmail(CurrentUser.getEmail());
        Set<Interest> set = user.getInterests();
        if(set.contains(interest)) {
            set.remove(interest);
            user.setInterests(set);
            userService.deleteUserInterest(interest, user);
            userRepository.save(user);
        }
        return set;
    }

    @Override
    public User updateUser(UpdateUserDto updateUserDto) {
        User user = userRepository.findByEmail(CurrentUser.getEmail());
        if(updateUserDto.getPhone() != null) user.setPhone(updateUserDto.getPhone());
        if(updateUserDto.getLogin() != null) user.setName(updateUserDto.getLogin());
        if(updateUserDto.getEmail() != null) user.setEmail(updateUserDto.getEmail());
        userRepository.save(user);
        return user;
    }
}
