package ru.findplace.demo.service.registration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.findplace.demo.entity.Interest;
import ru.findplace.demo.entity.User;
import ru.findplace.demo.repository.InterestRrepository;
import ru.findplace.demo.repository.UserRepository;

import java.util.HashSet;
import java.util.Set;

@Service
public class RegistrationServiceImpl implements RegistrationService {

    @Autowired
    private final UserRepository userRepository;
    private final InterestRrepository interestRrepository;

    public RegistrationServiceImpl(UserRepository userRepository, InterestRrepository interestRrepository) {
        this.userRepository = userRepository;
        this.interestRrepository = interestRrepository;
    }

    @Override
    public boolean addUser(User userRequestDto) {
        User user = userRepository.findFirstByEmail(userRequestDto.getEmail());
        if (user != null) {
            return false;
        }
        userRequestDto.setInterests(getInterestsIds(userRequestDto.getInterests()));
        userRepository.save(userRequestDto);
        return true;
    }

    private Set<Interest> getInterestsIds(Set<Interest> userRequestDtoSet) {
        Set<Interest> ids = new HashSet<>();
        for (Interest i : userRequestDtoSet) {
            Interest responseInterest = interestRrepository.findFirstByName(i.getName());
            if (responseInterest != null) {
                ids.add(responseInterest);
            }
        }
        return ids;
    }
}
