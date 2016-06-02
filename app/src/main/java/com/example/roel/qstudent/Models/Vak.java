package com.example.roel.qstudent.Models;

import java.util.List;

/**
 * Created by Roel on 02/06/2016.
 */
public class Vak {
    private String naam;
    private List<Onderdeel> onderdelen;

    public Vak(String naam, List<Onderdeel> onderdelen) {
        this.naam = naam;
        this.onderdelen = onderdelen;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public List<Onderdeel> getOnderdelen() {
        return onderdelen;
    }

    public void setOnderdelen(List<Onderdeel> onderdelen) {
        this.onderdelen = onderdelen;
    }
}
