package com.example.roel.qstudent.Activitys;

import android.os.Bundle;
import android.widget.ListView;

import com.example.roel.qstudent.Models.Forum.ForumController;
import com.example.roel.qstudent.Models.NavBar.NavBar;
import com.example.roel.qstudent.Models.Onderdeel;
import com.example.roel.qstudent.Models.OnderdeelForum.OnderdeelAdapter;
import com.example.roel.qstudent.Models.Post;
import com.example.roel.qstudent.R;

import java.util.ArrayList;

/**
 * Created by royti on 8-6-2016.
 */
public class OnderdeelActivity extends NavBar {

    ForumController onderdeelController;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onderdeel);
        super.setupBar(this,savedInstanceState);


        //Mock Onderdelen:
        ArrayList<Onderdeel> Onderdelen = new ArrayList<>();
        Onderdelen.add(new Onderdeel("Framework", new ArrayList<Post>()));
        Onderdelen.add(new Onderdeel("Opdracht week 15", new ArrayList<Post>()));
        Onderdelen.add( new Onderdeel("Koch Fractal", new ArrayList<Post>()));

        onderdeelController = new ForumController(this);


        OnderdeelAdapter oa = new OnderdeelAdapter(this, R.layout.profile_cust_listitem, onderdeelController.getOnderdelen());

        ListView OnderdeelList = (ListView) findViewById(R.id.onderdeelListView);
        OnderdeelList.setAdapter(oa);
    }
}
