package com.example.roel.qstudent.Models.Class;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.roel.qstudent.Models.Student;
import com.example.roel.qstudent.R;

import java.util.ArrayList;

/**
 * Created by Roel on 22/06/2016.
 */
public class ListAdapter extends ArrayAdapter<Student> {

    private final Context context;
    private final ArrayList<Student> itemsArrayList;

    public ListAdapter(Context context, ArrayList<Student> itemsArrayList) {

        super(context, R.layout.classlistitem, itemsArrayList);

        this.context = context;
        this.itemsArrayList = itemsArrayList;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        // 1. Create inflater
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        // 2. Get rowView from inflater
        View rowView = inflater.inflate(R.layout.classlistitem, parent, false);

        // 3. Get the two text view from the rowView
        ImageView imgStudent = (ImageView) rowView.findViewById(R.id.imgStudent);
        TextView naamStudent = (TextView) rowView.findViewById(R.id.naamStudent);
        TextView fPunten = (TextView) rowView.findViewById(R.id.fPunten);

        // 4. Set the text for textView
        imgStudent.setImageResource(R.mipmap.ic_kerel);
        naamStudent.setText(itemsArrayList.get(position).getNaam());
        //fPunten.setText(itemsArrayList.get(position).getforumPunten());
        fPunten.setText("1000 Points");

        // 5. return rowView
        return rowView;
    }
}