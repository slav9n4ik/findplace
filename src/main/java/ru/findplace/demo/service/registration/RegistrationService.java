package ru.findplace.demo.service.registration;

import ru.findplace.demo.Dtos.UserRequestDto;

public interface RegistrationService {
    String addUser(UserRequestDto userRequestDto);
}
