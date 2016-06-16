package com.example.roel.qstudent.Models.SemesterForum;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.roel.qstudent.Models.Semester;
import com.example.roel.qstudent.Models.Vak;
import com.example.roel.qstudent.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by royti on 16-6-2016.
 */
public class SemesterAdapter extends ArrayAdapter<Semester> {
    Context con;
    int lrID;
    List<Semester> data;
    public SemesterAdapter(Context context, int resource, ArrayList<Semester> data) {
        super(context, resource);
        this.con=context;
        this.lrID=resource;
        this.data = data;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        if(convertView == null) {
            LayoutInflater inf = ((Activity)con).getLayoutInflater();
            convertView=inf.inflate(lrID,parent,false);
        }
        Semester s= data.get(position);
        TextView semesterNaam = (TextView) convertView.findViewById(R.id.textViewForumCustList);

        semesterNaam.setText(s.getNaam());
        return convertView;
    }
}
