package com.example.roel.qstudent.Models.VakForum;

import com.example.roel.qstudent.Models.Vak;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by royti on 15-6-2016.
 */
public class VakController {
    ArrayList<Vak> vakken;

    public VakController(ArrayList<Vak> vakken) {
        this.vakken = vakken;
    }

    public ArrayList<Vak> getVakken() {
        return vakken;
    }

}
