package ru.findplace.demo.service.registration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.findplace.demo.Dtos.UserRequestDto;
import ru.findplace.demo.entity.User;
import ru.findplace.demo.repository.UserRepository;

@Service
public class RegistrationServiceImpl implements RegistrationService {

    @Autowired
    private final UserRepository userRepository;

    public RegistrationServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public boolean addUser(UserRequestDto userRequestDto) {
        User user = userRepository.findFirstByEmail(userRequestDto.getEmail());
        return user == null;
    }
}
