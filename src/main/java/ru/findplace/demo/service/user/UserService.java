package ru.findplace.demo.service.user;

import org.springframework.security.core.userdetails.UserDetailsService;
import ru.findplace.demo.Dtos.UserRegistrationDto;
import ru.findplace.demo.entity.Interest;
import ru.findplace.demo.entity.User;

import java.util.List;
import java.util.Set;

public interface UserService extends UserDetailsService {
    User findByEmail(String email);

    User save(UserRegistrationDto registration, List<String> interestValues);

    Set<Interest> getUserInterests();

    void deleteUserInterest(Interest interest, User user);
    void subscribeUser(Interest i, User user);
}
