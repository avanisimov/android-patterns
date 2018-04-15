package com.example.sdk.features.firstfeature.models;


import com.example.sdk.commons.models.ModelAbstract;

public class ListItem extends ModelAbstract {
    private int id;
    private String name;

    public ListItem(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
