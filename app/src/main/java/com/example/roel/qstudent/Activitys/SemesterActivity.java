package com.example.roel.qstudent.Activitys;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.roel.qstudent.Models.Forum.ForumController;
import com.example.roel.qstudent.Models.NavBar.NavBar;
import com.example.roel.qstudent.Models.SemesterForum.SemesterAdapter;
import com.example.roel.qstudent.R;

/**
 * Created by royti on 16-6-2016.
 */
public class SemesterActivity extends NavBar {
    ForumController forumController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_semester);
        super.setupBar(this, savedInstanceState);
        super.barLoaded(this);

        forumController = new ForumController(this);

        SemesterAdapter sa = new SemesterAdapter(this, R.layout.forum_cust_listitem, forumController.getSemesters());
        ListView lvSemester = (ListView) findViewById(R.id.semesterListView);
        lvSemester.setAdapter(sa);

        /*
        lvSemester.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(parent.getContext(),VakActivity.class);
                //intent.putExtra("Semester", lvSemester.getItemAtPosition(position).toString());
                startActivity(intent);

            }
        });*/

    }
}
