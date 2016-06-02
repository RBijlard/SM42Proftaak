package com.example.roel.qstudent.Models;

import android.support.annotation.Nullable;

import java.util.List;

/**
 * Created by Roel on 02/06/2016.
 */
public class Student {

    private String naam;
    private Klas klas;
    private List<Cijfer> cijferlijst = null;
    private int forumPunten = 0;

    public Student(String naam, Klas klas, @Nullable List<Cijfer> cijferlijst) {
        this.naam = naam;
        this.klas = klas;

        if (cijferlijst != null) {
            this.cijferlijst = cijferlijst;
        }
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public Klas getKlas() {
        return klas;
    }

    public void setKlas(Klas klas) {
        this.klas = klas;
    }

    public List<Cijfer> getCijferlijst() {
        return cijferlijst;
    }

    public void setCijferlijst(List<Cijfer> cijferlijst) {
        this.cijferlijst = cijferlijst;
    }

    public int getforumPunten() {
        return forumPunten;
    }

    public void addforumPunten(int forumPunten) {
        this.forumPunten += forumPunten;
    }

    @Override
    public String toString() {
        return "Student{" +
                "naam='" + naam + '\'' +
                ", klas=" + klas +
                ", cijferlijst=" + cijferlijst +
                ", forumPunten=" + forumPunten +
                '}';
    }
}
