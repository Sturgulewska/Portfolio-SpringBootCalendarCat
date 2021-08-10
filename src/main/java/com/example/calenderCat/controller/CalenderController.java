package com.example.calenderCat.controller;

import com.example.calenderCat.dto.CalenderDto;
import com.example.calenderCat.service.CalenderService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calender")
@CrossOrigin

public class CalenderController {

    private final CalenderService calenderService;

    public CalenderController(CalenderService calenderService) {
        this.calenderService = calenderService;
    }

    @RequestMapping(value = "calender/{getCalender}", method = RequestMethod.GET)
    public ResponseEntity<Object> getCalender() throws JsonProcessingException {
        CalenderDto response = calenderService.getCalender();
        return new ResponseEntity<>(response, HttpStatus.OK);

    }
}
