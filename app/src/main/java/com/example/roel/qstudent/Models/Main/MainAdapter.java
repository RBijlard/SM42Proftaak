package com.example.roel.qstudent.Models.Main;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.roel.qstudent.Models.Cijfer;
import com.example.roel.qstudent.R;

/**
 * Created by Robin on 6/4/2016.
 */
public class MainAdapter extends ArrayAdapter<String> {
    Context con;
    int lrID;
    String[] data;

    public MainAdapter(Context mContext, int layoutResourceId, String[] data) {
        super(mContext, layoutResourceId, data);
        this.con = mContext;
        this.lrID = layoutResourceId;
        this.data = data;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null) {
            LayoutInflater inf = ((Activity) con).getLayoutInflater();
            convertView= inf.inflate(lrID, parent, false);
        }
        String s = data[position];
        TextView description = (TextView) convertView.findViewById(R.id.mainDescription);

        description.setText(s);
        return convertView;
    }
}
