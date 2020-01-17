package com.training.restapi.controller;

import java.util.List;

import javax.validation.ValidationException;

import com.training.restapi.model.Jukebox;
import com.training.restapi.service.JukeboxSettingsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JukeboxSettingsController{

    @Autowired
    private JukeboxSettingsService service;

    @GetMapping("/jukeboxlist/{settingId}/{model}/{offset}/{limit}")
    public List<Jukebox> getJukeboxList(String settingId, String model, Integer offset, Integer limit){
        if(settingId == null) throw new ValidationException("settingId can not be null");
        return service.getJukeboxList(settingId, model, offset, limit);
    }

    @ExceptionHandler(ValidationException.class)
    ResponseEntity<String> responseEntity(ValidationException e){
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }
}