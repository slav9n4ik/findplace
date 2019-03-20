package ru.findplace.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.findplace.demo.entity.Interest;
import ru.findplace.demo.repository.InterestRrepository;
import ru.findplace.demo.response.InterestResponse;
import ru.findplace.demo.response.base.ResponseBuilder;
import ru.findplace.demo.response.base.ResponseWrapper;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class InterestController extends ResponseBuilder {
    Logger LOG = LoggerFactory.getLogger(InterestController.class);

    private final InterestRrepository interestRrepository;

    @Autowired
    public InterestController(InterestRrepository interestRrepository) {
        this.interestRrepository = interestRrepository;
    }

    @GetMapping(value = "/interests")
    public ResponseEntity<ResponseWrapper> getInterests() {
        LOG.info("Get Interests request");
        List<Interest> interestList;
        InterestResponse response;
        try {
            interestList = interestRrepository.findAll();
            response = InterestResponse.INTEREST_READ_SUCCESS;
            LOG.info("Get Interest Lists response: " + interestList.toString());
        } catch (Exception e) {
            interestList = new ArrayList<>();
            response = InterestResponse.INTEREST_READ_CONFLICT;
            LOG.error("Get Interest response conflict: " + e.getMessage());
        }
        return render(interestList, response, HttpStatus.OK);
    }
}
