package ru.findplace.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.findplace.demo.Dtos.UpdateUserDto;
import ru.findplace.demo.entity.Interest;
import ru.findplace.demo.entity.User;
import ru.findplace.demo.response.SettingsResponse;
import ru.findplace.demo.response.base.Response;
import ru.findplace.demo.response.base.ResponseBuilder;
import ru.findplace.demo.response.base.ResponseWrapper;
import ru.findplace.demo.service.user.SettingsService;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping(value = "/api")
public class SettingsController extends ResponseBuilder {

    private final SettingsService settingsService;
    Logger LOG = LoggerFactory.getLogger(SettingsController.class);

    @Autowired
    public SettingsController(SettingsService settingsService) {
        this.settingsService = settingsService;
    }

    @GetMapping(value = "/getUser")
    public ResponseEntity<ResponseWrapper> getUser(){
        LOG.info("Get user request");
        Response response;
        UpdateUserDto userDto;
        try {
            userDto = settingsService.getUser();
            response = SettingsResponse.GET_SUCCESS;
            LOG.info("Get user request: " + userDto);
        } catch (Exception e) {
            userDto = null;
            response = SettingsResponse.GET_CONFLICT;
            LOG.error("Get user request conflict: " + e.getMessage());
        }
        return render(userDto, response, HttpStatus.OK);
    }

    @PutMapping(value = "/putInterest")
    public ResponseEntity<ResponseWrapper> putUserInterest(@RequestParam String interestName){
        LOG.info("Put user request");
        Response response;
        Set<Interest> interestList;
        try {
            interestList = settingsService.putUserInterest(interestName);
            response = SettingsResponse.PUT_SUCCESS;
            LOG.info("Put user request: " + interestList);
        } catch (Exception e) {
            interestList = new HashSet<>();
            response = SettingsResponse.PUT_CONFLICT;
            LOG.error("Put user request conflict: " + e.getMessage());
        }
        return render(interestList, response, HttpStatus.OK);
    }

    @DeleteMapping(value = "/deleteInterest")
    public ResponseEntity<ResponseWrapper> deleteUserInterest(@RequestParam String interestName) {
        LOG.info("Delete user request");
        Response response;
        Set<Interest> interestList;
        try {
            interestList = settingsService.deleteUserInterest(interestName);
            response = SettingsResponse.DELETE_SUCCESS;
            LOG.info("Delete user request: " + interestList);
        } catch (Exception e) {
            interestList = new HashSet<>();
            response = SettingsResponse.DELETE_CONFLICT;
            LOG.error("Delete user request conflict: " + e.getMessage());
        }
        return render(interestList, response, HttpStatus.OK);
    }

    @PostMapping(value = "/userUpdate")
    public ResponseEntity<ResponseWrapper> updateUser(@RequestBody UpdateUserDto updateUserDto) {
        LOG.info("Update user request");
        Response response;
        User responseDto;
        try {
            responseDto = settingsService.updateUser(updateUserDto);
            response = SettingsResponse.UPDATE_SUCCESS;
            LOG.info("Update user request: " + responseDto);
        } catch (Exception e) {
            responseDto = null;
            response = SettingsResponse.UPDATE_CONFLICT;
            LOG.error("Update user request conflict: " + e.getMessage());
        }
        return render(responseDto, response, HttpStatus.OK);
    }
}
