package com.example.roel.qstudent.Models.Class;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.roel.qstudent.Models.Cijfer;
import com.example.roel.qstudent.Models.Student;
import com.example.roel.qstudent.R;

/**
 * Created by Robin on 6/4/2016.
 */
public class ClassAdapter extends ArrayAdapter<Student> {
    Context con;
    int lrID;
    Student[] data;

    public ClassAdapter(Context mContext, int layoutResourceId, Student[] data) {
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
        return convertView;
    }
}
