package ru.findplace.demo.service.user;

import org.springframework.security.core.userdetails.UserDetailsService;
import ru.findplace.demo.Dtos.UserRegistrationDto;
import ru.findplace.demo.entity.User;

import java.util.List;

public interface UserService extends UserDetailsService {
    User findByEmail(String email);

    User save(UserRegistrationDto registration, List<String> interestValues);
}
