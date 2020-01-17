package com.training.restapi.model;

import java.util.List;

import com.training.restapi.repository.JukeBoxSettingsRepository;

import org.springframework.beans.factory.annotation.Autowired;

public class Jukebox{
    
    @Autowired
    private JukeBoxSettingsRepository jukeBoxRepository;
    
    private String id;
    private String model;
    private List<Component> components;

    public Jukebox(){}
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public List<Component> getComponents() {
        return components;
    }

    public void setComponents(List<Component> components) {
        this.components = components;
    }

    public List<Jukebox> getJukeList(String settingId, String model, Integer offset, Integer limit){
        return this.jukeBoxRepository.getJukeboxList(settingId, model, offset, limit);
    }

    public void setJukeBoxRepository(JukeBoxSettingsRepository jukeBoxRepository) {
        this.jukeBoxRepository = jukeBoxRepository;
    }
}