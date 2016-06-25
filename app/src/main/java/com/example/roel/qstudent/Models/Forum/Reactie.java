package com.example.roel.qstudent.Models.Forum;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.roel.qstudent.Models.Bericht;
import com.example.roel.qstudent.Models.Forum.postAwnsers;
import com.example.roel.qstudent.R;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class Reactie extends AppCompatActivity {
    private Button btnPlaceMessage;
    private EditText text;
    private int studentPicture;
    private int upvote;
    private int downvote;
    private String studentName;
    private ArrayList<Bericht> berichten = new ArrayList<Bericht>();
    private Bericht b;
    private Context context;
    private File file;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reactie);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        context = this;

        b = (Bericht) getIntent().getSerializableExtra("berichtList");
        if (b != null) {
            berichten.add(b);
        }

        studentPicture = R.mipmap.bertsmit;
        upvote = R.mipmap.upvote;
        downvote = R.mipmap.downvote;
        studentName = "Bert";

        btnPlaceMessage = (Button) findViewById(R.id.btnPlaatsen);
        text = (EditText) findViewById(R.id.txtPlaceAwnser);
        btnPlaceMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), postAwnsers.class);//AwnserList.class);//PostList.class);

                //berichten.add(new Bericht(studentName, text.getText().toString(), studentPicture));
                Bericht b = new Bericht(studentName, text.getText().toString(), studentPicture, upvote, downvote);
                intent.putExtra("getBerichten", b);

                // Write reactie to file
                //writeToFile(text.getText().toString(), studentName, studentPicture);

                //writeObjectToFile();
                startActivity(intent);
            }
        });
    }

    public void writeObjectToFile() {
        file = new File("QstudentData2.txt");
        try {
            FileOutputStream fos = new FileOutputStream(file);
            ObjectOutputStream out = new ObjectOutputStream(fos);
            for (Bericht b : berichten) {
                out.writeObject(b);
            }
            fos.close();
            out.close();
        } catch (IOException e) {
            System.out.println("Error message: " + e.toString());
        }

    }

    public void writeToFile(String bericht, String studentName, int studentPicture) {
        try {
            OutputStreamWriter writer = new OutputStreamWriter(context.openFileOutput("QstudentData.txt", Context.MODE_PRIVATE));
            writer.write(bericht + ";");
            writer.write(studentName + ";");
            writer.write(studentPicture + ";");
            writer.close();
        } catch (IOException e) {
            System.out.println("Error message: " + e.toString());
        }
    }
}
