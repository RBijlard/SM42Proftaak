package com.example.roel.qstudent.Models.Forum;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.roel.qstudent.Models.Bericht;
import com.example.roel.qstudent.Models.InformationProvider.AwnserProvider;
import com.example.roel.qstudent.Models.InformationProvider.PostProvider;
import com.example.roel.qstudent.Models.Post;
import com.example.roel.qstudent.R;

public class AwnserList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_postlist_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        // Getting the position number from the chosen post
        int berichtPosition = getIntent().getIntExtra("berichtPosition", 0);
        Bericht bericht  = AwnserProvider.getAwnser(berichtPosition);

        // Making text variables and bind them with and exisiting text ID.
        TextView postTitle = (TextView)findViewById(R.id.postStudentAwnserQuestionTitle);
        TextView studentName = (TextView)findViewById(R.id.postStudentAwnserQuestionName);
        //TextView studentPoint = (TextView)findViewById(R.id.studentPoints);
        TextView studentBeschrijving = (TextView)findViewById(R.id.postStudentAwnserQuestionText);
        ImageView studentPicture = (ImageView)findViewById(R.id.postStudentAwnserQuestionPicture);

        // Setting the textview elements with new values of the list
        studentName.setText(" " + bericht.posterName);
        postTitle.setText(" " + bericht.inhoud);
        //studentPoint.setText(" " + post.punt);
        //studentBeschrijving.setText(" " + post.beschrijving);
        studentPicture.setImageResource(bericht.posterPicture);
    }

}
