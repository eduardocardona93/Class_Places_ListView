package com.example.class_places_listview;

import java.util.ArrayList;

public class Place {
    private String name;
    private String country;
    private String description;
    private ArrayList<String> images;

    public Place(String name, String country, String description, ArrayList<String> images) {
        this.name = name;
        this.country = country;
        this.description = description;
        this.images = images;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public String getDescription() {
        return description;
    }

    public ArrayList<String> getImages() {
        return images;
    }
}
