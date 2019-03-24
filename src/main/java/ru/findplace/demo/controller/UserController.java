package ru.findplace.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.findplace.demo.Dtos.UserRegistrationDto;
import ru.findplace.demo.entity.Interest;
import ru.findplace.demo.entity.User;
import ru.findplace.demo.repository.InterestRepository;
import ru.findplace.demo.service.user.UserService;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping("/registration")
public class UserController {

    Logger LOG = LoggerFactory.getLogger(UserController.class);

    private final UserService userService;
    private final InterestRepository interestRepository;

    @Autowired
    public UserController(UserService userService, InterestRepository interestRepository) {
        this.userService = userService;
        this.interestRepository = interestRepository;
    }

    @ModelAttribute("user")
    public UserRegistrationDto userRegistrationDto() {
        return new UserRegistrationDto();
    }

    @ModelAttribute
    public void initValues(Model model) {
        List<String> interestTypes = new ArrayList<>();
        List<Interest> allInterests = interestRepository.findAll();
        allInterests.forEach(interest -> interestTypes.add(interest.getName()));
        model.addAttribute("interest_types", interestTypes);
    }

    @GetMapping
    public String showRegistrationForm() {
        return "registration";
    }

    @PostMapping
    public String registerUserAccount(@ModelAttribute("user") @Valid UserRegistrationDto userDto,
                                      @RequestParam List<String> interestValues,
                                      BindingResult result) {

        LOG.info("Registration request");
        try {
            User existing = userService.findByEmail(userDto.getEmail());
            if (existing != null) {
                result.rejectValue("email", null, "Пользователь с таким email уже существует");
            }

            if (result.hasErrors()) {
                return "registration";
            }
            userService.save(userDto, interestValues);
            LOG.info("Registration response: User saved." + userDto);
        } catch (Exception e) {
            e.printStackTrace();
            LOG.error("Registration response conflict: " + e.getMessage());
        }
        return "redirect:/registration?success";
    }
}
