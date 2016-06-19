package com.example.roel.qstudent.Models.Class;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.roel.qstudent.Models.Klas;
import com.example.roel.qstudent.Models.Semester;
import com.example.roel.qstudent.Models.Student;
import com.example.roel.qstudent.R;

/**
 * A placeholder fragment containing a simple view.
 */
public class ClassList extends Fragment {

    public ClassList() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_classList, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        Klas klas = new Klas("S43", null, new Semester("Semester 4", null));

        //Mock students:
        Student[] students = {
                new Student("Bertje Bertsma Bertelstein", klas, null),
                new Student("Fred Henk", klas, null),
                new Student("Bart Smitz", klas, null),
                new Student("Henk Schilder", klas, null),
                new Student("Berta Koe", klas, null)
        };

        ListView classListView = (ListView) findViewById(R.id.classListView);

        classListView.setAdapter(new ClassAdapter(this, R.layout.activity_classList, students));
    }
}
