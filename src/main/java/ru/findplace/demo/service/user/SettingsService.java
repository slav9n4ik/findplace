package ru.findplace.demo.service.user;

import ru.findplace.demo.Dtos.UpdateUserDto;
import ru.findplace.demo.entity.Interest;
import ru.findplace.demo.entity.User;

import java.util.Set;

public interface SettingsService {
    Set<Interest> putUserInterest(String interestName);
    Set<Interest> deleteUserInterest(String interestName);
    User updateUser(UpdateUserDto updateUserDto);
}
