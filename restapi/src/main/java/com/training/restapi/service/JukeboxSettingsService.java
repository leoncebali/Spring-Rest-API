package com.training.restapi.service;

import java.util.List;

import com.training.restapi.model.Jukebox;
import com.training.restapi.repository.JukeBoxSettingsRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JukeboxSettingsService {
    
    @Autowired
    private JukeBoxSettingsRepository repository;
    
    public List<Jukebox> getJukeboxList(String settingId, String model, Integer offset, Integer limit){
        return getAllJukebox(settingId, model, offset, limit);
    }

    
    public List<Jukebox> getAllJukebox(String settingId, String model, Integer offset, Integer limit){
        return this.repository.getJukeboxList(settingId, model, offset, limit);
    }
}