package com.example.roel.qstudent.Activitys;

import android.os.Bundle;
import android.widget.ListView;

import com.example.roel.qstudent.Models.NavBar.NavBar;
import com.example.roel.qstudent.Models.Onderdeel;
import com.example.roel.qstudent.Models.OnderdeelForum.OnderdeelAdapter;
import com.example.roel.qstudent.R;

import java.util.ArrayList;

/**
 * Created by royti on 8-6-2016.
 */
public class OnderdeelActivity extends NavBar {

    OnderdeelController onderdeelController;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onderdeel);
        super.setupBar(this,savedInstanceState);


        //Mock Onderdelen:
        ArrayList<Onderdeel> Onderdelen = new ArrayList<>();
        Onderdelen.add(new Onderdeel("Framework",null,null));
        Onderdelen.add(new Onderdeel("Opdracht week 15", null, null));
        Onderdelen.add( new Onderdeel("Koch Fractal", null, null));

        onderdeelController = new OnderdeelController(Onderdelen);


        OnderdeelAdapter oa = new OnderdeelAdapter(this, R.layout.profile_cust_listitem, onderdeelController.getOnderdelen());

        ListView OnderdeelList = (ListView) findViewById(R.id.onderdeelListView);
        OnderdeelList.setAdapter(oa);
    }
}
