package com.example.roel.qstudent.Models;

import java.util.List;

/**
 * Created by Roel on 02/06/2016.
 */
public class Klas {
    private String naam;
    private List<Student> studenten;
    private Semester semester;

    public Klas(String naam, List<Student> studenten, Semester semester) {
        this.naam = naam;
        this.studenten = studenten;
        this.semester = semester;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public List<Student> getStudenten() {
        return studenten;
    }

    public void setStudenten(List<Student> studenten) {
        this.studenten = studenten;
    }

    public Semester getSemester() {
        return semester;
    }

    public void setSemester(Semester semester) {
        this.semester = semester;
    }
}
