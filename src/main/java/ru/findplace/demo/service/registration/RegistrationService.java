package ru.findplace.demo.service.registration;

import ru.findplace.demo.entity.User;

public interface RegistrationService {
    boolean addUser(User userRequestDto);
}
