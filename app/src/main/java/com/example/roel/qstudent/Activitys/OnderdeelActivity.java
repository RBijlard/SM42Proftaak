package com.example.roel.qstudent.Activitys;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.roel.qstudent.Models.Forum.ForumController;
import com.example.roel.qstudent.Models.Forum.Post_activity;
import com.example.roel.qstudent.Models.NavBar.NavBar;
import com.example.roel.qstudent.Models.Onderdeel;
import com.example.roel.qstudent.Models.OnderdeelForum.OnderdeelAdapter;
import com.example.roel.qstudent.Models.Post;
import com.example.roel.qstudent.Models.Vak;
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
        super.setupBar(this, savedInstanceState);
        super.barLoaded(this);

        onderdeelController = new ForumController(this);
        String vak = getIntent().getStringExtra("Vak");
        ArrayList<Onderdeel> onderdelen = onderdeelController.getOnderdeelBijVak(vak);

        if (onderdelen != null) {
            final ListView OnderdeelList = (ListView) findViewById(R.id.onderdeelListView);
            OnderdeelAdapter oa = new OnderdeelAdapter(this, R.layout.forum_cust_listitem, onderdelen);
            OnderdeelList.setAdapter(oa);

            OnderdeelList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Intent intent = new Intent(view.getContext(), Post_activity.class);
                    startActivity(intent);
                }
            });
        }
    }
}
