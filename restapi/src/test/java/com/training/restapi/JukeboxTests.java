package com.training.restapi;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import com.training.restapi.repository.JukeBoxSettingsRepository;
import com.training.restapi.model.*;

import org.junit.Test;
import org.mockito.Mockito;

public class JukeboxTests {

    private static final String MODEL = "model5";
    private static final String SETTINGS_ID = "09809898as8908a0ds9f890adf";
    private static final Integer OFFSET = 0;
    private static final Integer LIMIT = 10;

    Jukebox instance = new Jukebox();
    private JukeBoxSettingsRepository repository;
    List<Jukebox> jukeboxs = new ArrayList<>();
    
    @Test
    public void Jukebox(){
        instance.setId(SETTINGS_ID);
            instance.setModel(MODEL);
            List<Component> list = new ArrayList<>();
            Component component = new Component();
            component.setName(MODEL);
            list.add(component);
            instance.setComponents(list);
            jukeboxs.add(instance);
            repository = Mockito.mock(JukeBoxSettingsRepository.class);
            instance.setJukeBoxRepository(repository);
            
            Mockito.when(repository.getJukeboxList(SETTINGS_ID, MODEL, OFFSET, LIMIT)).thenReturn(jukeboxs);
            
            List<Jukebox> result = instance.getJukeList(SETTINGS_ID, MODEL, OFFSET, LIMIT);
            assertEquals(jukeboxs, result);
    }
}