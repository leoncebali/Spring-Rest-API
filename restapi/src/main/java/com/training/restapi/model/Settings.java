package com.training.restapi.model;

import java.util.Collection;

public class Settings {
    
    private String id;
    private Collection<String> requires;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Collection<String> getRequires() {
        return requires;
    }

    public void setRequires(Collection<String> requires) {
        this.requires = requires;
    }
}