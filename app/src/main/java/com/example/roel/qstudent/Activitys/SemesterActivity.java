package com.example.roel.qstudent.Activitys;

import android.os.Bundle;

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
        setContentView(R.layout.activity_vak);
        super.setupBar(this,savedInstanceState);

        forumController = new ForumController(this);

        SemesterAdapter sa = new SemesterAdapter(this, R.layout.forum_cust_listitem, forumController.getSemesters());
    }
}
