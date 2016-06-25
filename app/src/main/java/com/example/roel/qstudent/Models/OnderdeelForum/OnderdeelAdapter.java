package com.example.roel.qstudent.Models.OnderdeelForum;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.TextView;

import com.example.roel.qstudent.Models.Onderdeel;
import com.example.roel.qstudent.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by royti on 8-6-2016.
 */
public class OnderdeelAdapter extends ArrayAdapter<Onderdeel> {
    Context con;
    int lrID;
    List<Onderdeel> data;
    public OnderdeelAdapter(Context context, int resource,ArrayList<Onderdeel> data) {
        super(context, resource);
        this.con=context;
        this.lrID=resource;
        this.data = data;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        if(convertView == null) {
            LayoutInflater inf = ((Activity)con).getLayoutInflater();
            convertView=inf.inflate(lrID,parent,false);
        }
        Onderdeel o = data.get(position);
        TextView onderdeelNaam = (TextView) convertView.findViewById(R.id.textViewForumCustList);

        onderdeelNaam.setText(o.getNaam());
        return convertView;
    }
}
