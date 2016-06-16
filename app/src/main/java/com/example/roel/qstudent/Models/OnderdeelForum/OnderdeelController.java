package com.example.roel.qstudent.Models.OnderdeelForum;

import com.example.roel.qstudent.Models.Onderdeel;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by royti on 8-6-2016.
 */
public class OnderdeelController {
    ArrayList<Onderdeel> onderdeelList;

    public OnderdeelController(ArrayList<Onderdeel> onderdeelList) {
        this.onderdeelList = onderdeelList;
    }

    public ArrayList<Onderdeel> getOnderdelen()
    {
        return onderdeelList;
    }
}
