package ru.gerkir;

import java.beans.JavaBean;

@JavaBean
public class Hookah {
    private String name;
    private String description;
    private String address;
    private String picture;

    public Hookah(String name, String description, String address, String picture) {
        this.name = name;
        this.description = description;
        this.address = address;
        this.picture = picture;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }
}
