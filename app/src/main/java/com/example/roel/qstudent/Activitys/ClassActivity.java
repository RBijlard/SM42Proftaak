package com.example.roel.qstudent.Activitys;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.PagerTitleStrip;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.roel.qstudent.Models.Class.CustomPagerAdapter;
import com.example.roel.qstudent.Models.Class.ListAdapter;
import com.example.roel.qstudent.Models.Class.PageTransformer;
import com.example.roel.qstudent.Models.NavBar.NavBar;
import com.example.roel.qstudent.Models.Student;
import com.example.roel.qstudent.R;

import java.util.ArrayList;
import java.util.Vector;

public class ClassActivity extends NavBar {
    private Context context;

    //initializing all students
    private Student s1 = new Student("Pieter Jensen", null, null);
    private Student s2 = new Student("Henk Worst", null, null);
    private Student s3 = new Student("Berry Bob", null, null);
    private Student s4 = new Student("Henk Schilder", null, null);
    private Student s5 = new Student("Hans G", null, null);
    private Student s6 = new Student("Bob Bouwer", null, null);

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setupBar(this, savedInstanceState);
        super.barLoaded(this);
        context = this;
        setContentView(R.layout.activity_class);

        //initializing student list
        ArrayList<Student> students = new ArrayList<>();
        students.add(s1);
        students.add(s2);
        students.add(s3);
        students.add(s4);
        students.add(s5);
        students.add(s6);

        //initializing all listviews and setting the adapters
        final ListView listview1 = new ListView(context);
        listview1.setAdapter(new ListAdapter(this, students));

        final ListView listview2 = new ListView(context);
        listview2.setAdapter(new ListAdapter(this, students));

        final ListView listview3 = new ListView(context);
        listview3.setAdapter(new ListAdapter(this, students));

        Vector<View> pages = new Vector<>();

        // setting all the pages
        pages.add(listview1);
        pages.add(listview2);
        pages.add(listview3);

        final ViewPager vp = (ViewPager) findViewById(R.id.viewpager);
        vp.setPageTransformer(true, new PageTransformer());

        CustomPagerAdapter adapter = new CustomPagerAdapter(context, pages);
        vp.setAdapter(adapter);

        //setting all the OnItemClickListener
        listview1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                Object o = listview1.getItemAtPosition(position);
                Intent i = new Intent(context, ProfileActivity.class);
                context.startActivity(i);
            }
        });

        listview2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                Object o = listview1.getItemAtPosition(position);
                Intent i = new Intent(context, ProfileActivity.class);
                context.startActivity(i);
            }
        });

        listview3.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                Object o = listview1.getItemAtPosition(position);
                Intent i = new Intent(context, ProfileActivity.class);
                context.startActivity(i);
            }
        });
    }
}