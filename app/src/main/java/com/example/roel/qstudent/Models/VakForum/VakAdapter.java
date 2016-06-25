package com.example.roel.qstudent.Models.VakForum;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.roel.qstudent.Models.Onderdeel;
import com.example.roel.qstudent.Models.Vak;
import com.example.roel.qstudent.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by royti on 15-6-2016.
 */
public class VakAdapter extends ArrayAdapter<Vak> {
    Context con;
    int lrID;
    List<Vak> data;
    public VakAdapter(Context context, int resource,ArrayList<Vak> data) {
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
        Vak v = data.get(position);
        TextView vakNaam = (TextView) convertView.findViewById(R.id.textViewForumCustList);

        vakNaam.setText(v.getNaam());
        return convertView;
    }
}
