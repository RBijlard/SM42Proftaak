package com.example.roel.qstudent.Activitys;

import android.os.Bundle;
import android.widget.ListView;

import com.example.roel.qstudent.Models.Main.MainAdapter;
import com.example.roel.qstudent.Models.NavBar.NavBar;
import com.example.roel.qstudent.R;

import java.util.List;

public class MainActivity extends NavBar {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Setup toolbar:
        super.setupBar(this, savedInstanceState);
        super.barLoaded(this);

        //Mock data:
        String[] dataVJ = new String[] {
                "Media strategie",
                "Customer journey",
                "Communicatiestrategie"
        };

        String[] dataHA = new String[] {
                "SEO htaccess werkt niet?",
                "Hoe moet ik een framework..",
                "Leerdoelen voor prototyping"
        };

        //Adapters:
        MainAdapter vja = new MainAdapter(this, R.layout.main_cust_listitem, dataVJ);
        ListView vjList = (ListView) findViewById(R.id.mainVoorJouList);
        vjList.setAdapter(vja);

        MainAdapter ha = new MainAdapter(this, R.layout.main_cust_listitem, dataHA);
        ListView haList = (ListView) findViewById(R.id.mainHelpAnderenList);
        haList.setAdapter(ha);


    }
}
