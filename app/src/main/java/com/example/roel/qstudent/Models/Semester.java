package com.example.roel.qstudent.Models;

import java.util.List;

/**
 * Created by Roel on 02/06/2016.
 */
public class Semester {
    public String naam;
    public List<Vak> vakken;

    public Semester(String naam, List<Vak> vakken) {
        this.naam = naam;
        this.vakken = vakken;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public List<Vak> getVakken() {
        return vakken;
    }

    public void setVakken(List<Vak> vakken) {
        this.vakken = vakken;
    }

    @Override
    public String toString() {
        return naam;
    }
}
