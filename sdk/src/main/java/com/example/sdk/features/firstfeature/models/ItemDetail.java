package com.example.sdk.features.firstfeature.models;


public class ItemDetail extends ListItem {

    private String description;

    public ItemDetail(int id, String name, String description) {
        super(id, name);
        this.description = description;
    }

    public ItemDetail(ListItem listItem, String description) {
        super(listItem.getId(), listItem.getName());
        this.description = description;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
