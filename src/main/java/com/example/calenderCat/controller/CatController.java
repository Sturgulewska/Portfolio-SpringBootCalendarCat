package com.example.calenderCat.controller;


import com.example.calenderCat.dto.CatDto;
import com.example.calenderCat.service.CatService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.mail.MessagingException;

@Controller
@RequestMapping("/cat")
@CrossOrigin
public class CatController {

    private final CatService catService;

    public CatController(CatService catService) {
        this.catService = catService;
    }

    @RequestMapping(value = "/cat/{get_cat}", method = RequestMethod.GET)
    public ResponseEntity<Object> getCat() throws JsonProcessingException, MessagingException {
        CatDto resultDto = catService.getCat();
        String result = "https://cataas.com"+
                resultDto.getUrlCat();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @RequestMapping(value = "/save_cat", method = RequestMethod.GET)
    public ResponseEntity<Object> saveCat() {
        catService.saveCat();
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
