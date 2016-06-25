package com.example.roel.qstudent.Activitys;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.roel.qstudent.Models.Forum.ForumController;
import com.example.roel.qstudent.Models.NavBar.NavBar;
import com.example.roel.qstudent.Models.Onderdeel;
import com.example.roel.qstudent.Models.Vak;
import com.example.roel.qstudent.Models.VakForum.VakAdapter;
import com.example.roel.qstudent.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by royti on 9-6-2016.
 */
public class VakActivity extends NavBar {
    ForumController vakController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vak);
        super.setupBar(this, savedInstanceState);
        super.barLoaded(this);
        vakController = new ForumController(this);

        String semester = getIntent().getStringExtra("Semester");
        ArrayList<Vak> vakken = vakController.getVakkenBijSemester(semester);

        if (vakken != null) {
            VakAdapter va = new VakAdapter(this, R.layout.forum_cust_listitem, vakken);
            final ListView vaListview = (ListView) findViewById(R.id.vakListView);
            vaListview.setAdapter(va);

            vaListview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    Intent intent = new Intent(parent.getContext(), OnderdeelActivity.class);
                    intent.putExtra("Vak", vakController.getVakken().get(position).toString());
                    startActivity(intent);
                }
            });
        }

    }
}
