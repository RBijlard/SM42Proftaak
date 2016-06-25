package com.example.roel.qstudent.Models.Forum;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.roel.qstudent.Models.InformationProvider.CustomListviewAdapter;
import com.example.roel.qstudent.Models.InformationProvider.PostProvider;
import com.example.roel.qstudent.Models.NavBar.NavBar;
import com.example.roel.qstudent.Models.Post;
import com.example.roel.qstudent.R;

import java.util.ArrayList;
import java.util.List;

public class Post_activity extends NavBar {

    private TextView aantalAntwoordenNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        super.setupBar(this, savedInstanceState);
        super.barLoaded(this);

        aantalAntwoordenNumber = (TextView)findViewById(R.id.postStudenAmountOfAwnsers);
        PostProvider postProvider = new PostProvider(this);
        postProvider.getPosts();

        ListView listView = (ListView)findViewById(R.id.listViewPosts);
        List<Post> items = new ArrayList<>();
        items.add(new Post(){{
            foto = R.mipmap.bertsmit;
            naam = "Hoeveel leden werken er in een proftaak??";
            poster = "Bert Smit";
            aantalAntwoorden = 3;
        }});
        items.add(new Post(){{
            foto = R.mipmap.yousefadador;
            naam = "Hulp nodig met project document";
            poster = "Yousef Adador";
            aantalAntwoorden = 3;
        }});
        items.add(new Post(){{
            foto = R.mipmap.claudiapols;
            naam = "Hulp nodig met een start project opzetten";
            poster = "Claudia Pols";
            aantalAntwoorden = 0;
        }});
        items.add(new Post() {{
            foto = R.mipmap.sarahjanssen;
            naam = "Welke onderdelen komen er aanbod?";
            poster = "Sarah Janssen";
            aantalAntwoorden = 2;
        }});

        CustomListviewAdapter adapter = new CustomListviewAdapter(this, items);
        listView.setAdapter(adapter);

        final String[] posts = getResources().getStringArray(R.array.studentPostTitle);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                String name = posts[position];

                Intent intent = new Intent(parent.getContext(), postAwnsers.class);
                intent.putExtra("postPosition", position);
                startActivity(intent);
            }
        });

        updateAwnsers();
    }

    public void updateAwnsers(){
        int aantalAntwoorden = getIntent().getIntExtra("aantalAntwoordenBertSmit", 3);
        if(aantalAntwoorden != 0){
            //aantalAntwoorden = getIntent().getExtras().getInt("aantalAntwoordenBertSmit");
            //aantalAntwoorden = getIntent().getExtras().getInt("aantalAntwoordenYousefAdador");
            //aantalAntwoorden = getIntent().getExtras().getInt("aantalAntwoordenSarahJanssen");
            //aantalAntwoordenNumber.setText(aantalAntwoorden);
        }

    }

}
