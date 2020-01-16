package com.training.restapi.model;

import java.util.List;

public class JukeboxSettings{

    private List<Settings> settings;

    public List<Settings> getSettings() {
        return settings;
    }

    public void setSettings(List<Settings> settings) {
        this.settings = settings;
    }
}