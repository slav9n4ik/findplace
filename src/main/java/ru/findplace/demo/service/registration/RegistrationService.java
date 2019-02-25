package ru.findplace.demo.service.registration;

import ru.findplace.demo.entity.User;
import ru.findplace.demo.exception.RegistrationException;

public interface RegistrationService {
    boolean addUser(User userRequestDto) throws RegistrationException;
}
