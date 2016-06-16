package com.example.roel.qstudent.Activitys;

import android.os.Bundle;

import com.example.roel.qstudent.Models.NavBar.NavBar;
import com.example.roel.qstudent.Models.Vak;
import com.example.roel.qstudent.Models.VakForum.VakAdapter;
import com.example.roel.qstudent.Models.VakForum.VakController;
import com.example.roel.qstudent.R;

import java.util.ArrayList;

/**
 * Created by royti on 9-6-2016.
 */
public class VakActivity extends NavBar {
    VakController vakController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vak);
        super.setupBar(this);

        ArrayList<Vak> vakken = new ArrayList<>();
        vakken.add(new Vak("JSF", null));
        vakken.add(new Vak("SM41", null));
        vakken.add(new Vak("GSO", null));

        vakController = new VakController(vakken);

        VakAdapter va = new VakAdapter(this, R.layout.forum_cust_listitem, vakController.getVakken());
    }
}
