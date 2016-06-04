package com.example.roel.qstudent.Models.Profile;

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
public class CijferAdapter extends ArrayAdapter<Cijfer> {
    Context con;
    int lrID;
    Cijfer[] data;

    public CijferAdapter(Context mContext, int layoutResourceId, Cijfer[] data) {
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
        Cijfer c = data[position];
        TextView vaknaam = (TextView) convertView.findViewById(R.id.custVaknaam);
        TextView cijfer= (TextView) convertView.findViewById(R.id.custCijfer);

        vaknaam.setText(c.getNaamVak());
        cijfer.setText(""+c.getCijfer()); //Set cijfer hier
        return convertView;
    }
}
