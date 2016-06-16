package com.example.roel.qstudent.Models.Forum;

import com.example.roel.qstudent.Models.Onderdeel;
import com.example.roel.qstudent.Models.Semester;
import com.example.roel.qstudent.Models.Vak;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by royti on 16-6-2016.
 */
public class ForumController {
    private static final String JSONurl = "https://api.myjson.com/bins/5araf";

    private ArrayList<Onderdeel> onderdelen;
    private ArrayList<Vak> vakken;
    private ArrayList<Semester> semesters;

    public ForumController() {
        onderdelen = new ArrayList<>();
        vakken = new ArrayList<>();
        semesters = new ArrayList<>();
    }

    public ArrayList<Onderdeel> getOnderdelen() {
        return onderdelen;
    }

    public ArrayList<Vak> getVakken() {
        return vakken;
    }

    public ArrayList<Semester> getSemesters() {
        return semesters;
    }
}
