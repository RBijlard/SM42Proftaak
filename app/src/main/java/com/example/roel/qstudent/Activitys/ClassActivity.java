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
import com.example.roel.qstudent.Models.NavBar.NavBar;
import com.example.roel.qstudent.R;

import java.util.Vector;

public class ClassActivity extends NavBar {
    private Context mContext;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setupBar(this, savedInstanceState);
        super.barLoaded(this);
        mContext = this;
        setContentView(R.layout.activity_class);

        final ListView listview1 = new ListView(mContext);
        final ListView listview2 = new ListView(mContext);
        final ListView listview3 = new ListView(mContext);

        Vector<View> pages = new Vector<>();

        pages.add(listview1);
        pages.add(listview2);
        pages.add(listview3);

        ViewPager vp = (ViewPager) findViewById(R.id.viewpager);
        CustomPagerAdapter adapter = new CustomPagerAdapter(mContext, pages);
        vp.setAdapter(adapter);

        listview1.setAdapter(new ArrayAdapter<>(mContext, android.R.layout.simple_list_item_1, new String[]{"Henk Worst", "Berry Bob", "Bob Bouwer", "Hans Vucht", "James May",
                "Daan Henk", "Hans G", "Joris Se", "Henk Schilder", "Pieter Jenson", "Joris En", "Test Naam"}));
        listview2.setAdapter(new ArrayAdapter<>(mContext, android.R.layout.simple_list_item_1, new String[]{"Henk Worst", "Berry Bob", "Bob Bouwer", "Hans Vucht", "James May",
                "Daan Henk", "Hans G", "Joris Se", "Henk Schilder", "Pieter Jenson", "Joris En", "Test Naam"}));
        listview3.setAdapter(new ArrayAdapter<>(mContext, android.R.layout.simple_list_item_1, new String[]{"Henk Worst", "Berry Bob", "Bob Bouwer", "Hans Vucht", "James May",
                "Daan Henk", "Hans G", "Joris Se", "Henk Schilder", "Pieter Jenson", "Joris En", "Test Naam"}));

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