package com.example.roel.qstudent.Activitys;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.roel.qstudent.Models.Cijfer;
import com.example.roel.qstudent.Models.Klas;
import com.example.roel.qstudent.Models.NavBar.NavBar;
import com.example.roel.qstudent.Models.Profile.CijferAdapter;
import com.example.roel.qstudent.Models.Student;
import com.example.roel.qstudent.R;

public class ProfileActivity extends NavBar {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        super.setupBar(this, savedInstanceState);
        super.barLoaded(this);

        //Mock cijfers:
        Cijfer[] cijfers = {
            new Cijfer("UXD", "User Experience Design", null),
            new Cijfer("SE42", "Software", null),
            new Cijfer("BS42", "Business", null),
            new Cijfer("KPO", "Ontwikkeling", null),
            new Cijfer("COM", "Communicatie", null),
        };
        cijfers[0].setCijfer(10.0);
        cijfers[1].setCijfer(7.5);
        cijfers[2].setCijfer(5.5);
        cijfers[3].setCijfer(5.5);
        cijfers[4].setCijfer(3.5);

        //Mock student:
        //Student s= new Student("Bertje Bertsma Bertelstein", new Klas(), null);


        CijferAdapter ca = new CijferAdapter(this, R.layout.profile_cust_listitem, cijfers);

        ListView cijferList = (ListView) findViewById(R.id.profileCijferList);
        //cijferList.setAdapter(ca);
    }
}
