package com.example.roel.qstudent.Models.Class;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.Vector;

/**
 * Created by Roel on 21/06/2016.
 */
public class CustomPagerAdapter extends PagerAdapter {

    private Context mContext;
    private Vector<View> pages;

    public CustomPagerAdapter(Context context, Vector<View> pages) {
        this.mContext = context;
        this.pages = pages;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View page = pages.get(position);
        container.addView(page);
        return page;
    }

    @Override
    public int getCount() {
        return pages.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view.equals(object);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0: {
                return "S42";
            }
            case 1: {
                return "S43";
            }
            case 2: {
                return "S44";
            }
        }

        return "Error";
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

}