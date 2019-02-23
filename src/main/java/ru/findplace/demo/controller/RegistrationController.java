package ru.findplace.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.findplace.demo.Dtos.UserRequestDto;
import ru.findplace.demo.response.RegistrationResponse;
import ru.findplace.demo.response.base.Response;
import ru.findplace.demo.response.base.ResponseBuilder;
import ru.findplace.demo.response.base.ResponseWrapper;
import ru.findplace.demo.service.registration.RegistrationService;

@RestController
@RequestMapping(value = "/api")
public class RegistrationController extends ResponseBuilder {

    Logger LOG = LoggerFactory.getLogger(CampaignController.class);
    private final RegistrationService registrationService;

    @Autowired
    public RegistrationController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @PostMapping(value = "/registration")
    public ResponseEntity<ResponseWrapper> addUser(@RequestBody UserRequestDto userRequestDto) {
        LOG.info("Registration request");
        Response response;
        String registrationResponse;
        try {
            registrationResponse = registrationService.addUser(userRequestDto);
            response = RegistrationResponse.REGISTRATION_SUCCESS;
            LOG.info("Registration response: " + registrationResponse);
        } catch (Exception e) {
            response = RegistrationResponse.REGISTRATION_CONFLICT;
            registrationResponse = e.getMessage();
            LOG.error("Registration response conflict: {}", e);
        }
        return render(registrationResponse, response, HttpStatus.OK);
    }
}
