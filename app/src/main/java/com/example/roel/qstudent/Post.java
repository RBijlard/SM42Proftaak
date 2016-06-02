package com.example.roel.qstudent;

import java.util.List;

/**
 * Created by Roel on 02/06/2016.
 */
public class Post {
    private String naam;
    private List<Bericht> berichten;

    public Post(String naam, List<Bericht> berichten) {
        this.naam = naam;
        this.berichten = berichten;
    }

    public List<Bericht> getBerichten() {
        return berichten;
    }

    public void setBerichten(List<Bericht> berichten) {
        this.berichten = berichten;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }
}
