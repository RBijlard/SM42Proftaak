package com.example.roel.qstudent.Activitys;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
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
    private Context mContext;

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
        mContext = this;
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
        final ListView listview1 = new ListView(mContext);
        listview1.setAdapter(new ListAdapter(this, students));

        final ListView listview2 = new ListView(mContext);
        listview2.setAdapter(new ListAdapter(this, students));

        final ListView listview3 = new ListView(mContext);
        listview3.setAdapter(new ListAdapter(this, students));

        Vector<View> pages = new Vector<>();

        // setting all the pages
        pages.add(listview1);
        pages.add(listview2);
        pages.add(listview3);

        ViewPager vp = (ViewPager) findViewById(R.id.viewpager);

        vp.setPageTransformer(true, new PageTransformer());

        CustomPagerAdapter adapter = new CustomPagerAdapter(mContext, pages);
        vp.setAdapter(adapter);

//        listview1.setAdapter(new ArrayAdapter<>(mContext, android.R.layout.simple_list_item_1, new String[]{"Henk Worst", "Berry Bob", "Bob Bouwer", "Hans Vucht", "James May",
//                "Daan Henk", "Hans G", "Joris Se", "Henk Schilder", "Pieter Jenson", "Joris En", "Test Naam"}));
//        listview2.setAdapter(new ArrayAdapter<>(mContext, android.R.layout.simple_list_item_1, new String[]{"Henk Worst", "Berry Bob", "Bob Bouwer", "Hans Vucht", "James May",
//                "Daan Henk", "Hans G", "Joris Se", "Henk Schilder", "Pieter Jenson", "Joris En", "Test Naam"}));
//        listview3.setAdapter(new ArrayAdapter<>(mContext, android.R.layout.simple_list_item_1, new String[]{"Henk Worst", "Berry Bob", "Bob Bouwer", "Hans Vucht", "James May",
//                "Daan Henk", "Hans G", "Joris Se", "Henk Schilder", "Pieter Jenson", "Joris En", "Test Naam"}));


        //setting all the onclicklistners
        listview1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                Object o = listview1.getItemAtPosition(position);
                Toast.makeText(getBaseContext(), o.toString(), Toast.LENGTH_SHORT).show();
            }
        });

        listview2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                Object o = listview1.getItemAtPosition(position);
                Toast.makeText(getBaseContext(), o.toString(), Toast.LENGTH_SHORT).show();
            }
        });

        listview3.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                Object o = listview1.getItemAtPosition(position);
                Toast.makeText(getBaseContext(), o.toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}