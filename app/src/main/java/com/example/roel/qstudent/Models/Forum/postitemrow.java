package com.example.roel.qstudent.Models.Forum;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageButton;

import com.example.roel.qstudent.R;

public class postitemrow extends AppCompatActivity {

    private ImageButton btnUpvote;
    private ImageButton btnDownvote;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.postitem_row);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        upvotePost();
        downvotePost();
    }

    public void upvotePost() {
        int punt = getIntent().getIntExtra("puntUpvote", 0);
        if(punt != 0){
            btnUpvote = (ImageButton)findViewById(R.id.postUpVote);
            btnUpvote.setOnClickListener(new View.OnClickListener() {
                int puntUpvote = 1;
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(v.getContext(), postAwnsers.class);
                    intent.putExtra("puntUpvote", puntUpvote);
                    startActivity(intent);
                }
            });
        }
    }

    public void downvotePost() {
        if(btnDownvote != null){
            btnDownvote = (ImageButton)findViewById(R.id.postDownVote);
            btnDownvote.setOnClickListener(new View.OnClickListener() {
                int puntDownvote = 1;
                @Override
                public void onClick(View v)
                {
                    Intent intent = new Intent(v.getContext(), postAwnsers.class);
                    intent.putExtra("puntDownvote", puntDownvote);
                    startActivity(intent);
                }
            });
        }

    }


}
