package com.training.restapi.repository;

import java.util.ArrayList;
import java.util.List;

import com.training.restapi.model.Component;
import com.training.restapi.model.Jukebox;

import org.springframework.stereotype.Repository;

@Repository
public class JukeBoxSettingsRepository {
    
public List<Jukebox> getJukeboxList(String settingId, String model, Integer offset, Integer limit) {
        List<Jukebox> list = new ArrayList<>();
        Jukebox juke = new Jukebox();
        juke.setId("09809898as8908a0ds9f890adf");
        juke.setModel(model);
        List<Component> components = new ArrayList<>();
        Component component = new Component();
        component.setName("Name");
        components.add(component);
        juke.setComponents(components);
        list.add(juke);
        return list;
    }
}