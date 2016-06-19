package com.example.roel.qstudent.Activitys;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import com.example.roel.qstudent.Models.Class.ClassList;
import com.example.roel.qstudent.Models.NavBar.NavBar;
import com.example.roel.qstudent.R;

public class ClassActivity extends NavBar {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_class);
        super.setupBar(this, savedInstanceState);
        super.barLoaded(this);

        ViewPager vpPager = (ViewPager) findViewById(R.id.vpPager);
        vpPager.setAdapter(new MyAdapter(getSupportFragmentManager()));

    }

    public class MyAdapter extends FragmentPagerAdapter {

        private int AMOUNT_OF_TABS = 5;

        public MyAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return new ClassList();
                case 1:
                    return new ClassList();
                case 2:
                    return new ClassList();
                case 3:
                    return new ClassList();
                case 4:
                    return new ClassList();
            }
            return null;
        }

        @Override
        public int getCount() {
            return AMOUNT_OF_TABS;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "S41";
                case 1:
                    return "S42";
                case 2:
                    return "S43";
                case 3:
                    return "S44";
                case 4:
                    return "S45";
            }
            return "Error";
        }
    }
}