package com.example.roel.qstudent.Models;

import java.util.List;

/**
 * Created by Roel on 02/06/2016.
 */
public class Post {
    private String naam;
    private List<Bericht> berichten;
    private Student poster;

    public Post(String naam, Student poster ,List<Bericht> berichten) {
        this.naam = naam;
        this.berichten = berichten;
        this.poster = poster;
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

    public Student getPoster() {
        return poster;
    }

    public void setPoster(Student poster) {
        this.poster = poster;
    }
}
