package com.example.roel.qstudent.Models;

import java.util.List;

/**
 * Created by Roel on 02/06/2016.
 */
public class Post {
    public String naam;
    public List<Bericht> berichten;
    public String poster;
    public int foto;
    public String punt;
    public String beschrijving;
    public int aantalAntwoorden;

    public Post() {//String naam, String poster ,List<Bericht> berichten, int foto) {
        this.naam = naam;
        this.berichten = berichten;
        this.poster = poster;
        this.foto = foto;
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

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public int getFoto() {
        return foto;
    }

    @Override
    public String toString() {
        String info = naam + " " + poster + " " + berichten;
        return info;
    }
}
