package com.example.roel.qstudent.Activitys;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.roel.qstudent.Models.Bericht;
import com.example.roel.qstudent.Models.InformationProvider.AwnserProvider;
import com.example.roel.qstudent.Models.InformationProvider.CustomListviewAdapterAwnser;
import com.example.roel.qstudent.Models.InformationProvider.PostProvider;
import com.example.roel.qstudent.Models.Post;
import com.example.roel.qstudent.R;
import com.example.roel.qstudent.Reactie;

import org.w3c.dom.Text;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PostList extends AppCompatActivity implements Serializable {
    private Context context;
    private ImageButton btnCreateAwnser;
    private TextView messageAwnser;
    private ImageView picture;
    private TextView name;
    private ArrayList<Bericht> berichten = new ArrayList<>();
    private EditText txtInput;
    private boolean yes = false;
    private ListView listView;
    private ArrayAdapter<String> awnserAdapter;
    private postAwnsers p;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_postlist_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        listView = (ListView) findViewById(R.id.listViewAwnsers);
        //readFromFile();
        // Getting the position number from the chosen post
        int postPosition = getIntent().getIntExtra("postPosition", 0);
        Post post = PostProvider.getPost(postPosition);

        // Making text variables and bind them with and exisiting text ID.
        TextView postTitle = (TextView) findViewById(R.id.postTitle);
        TextView studentName = (TextView) findViewById(R.id.postStudentName);
        //TextView studentPoint = (TextView)findViewById(R.id.studentPoints);
        TextView studentBeschrijving = (TextView) findViewById(R.id.studentBeschrijving);
        ImageView studentPicture = (ImageView) findViewById(R.id.postStudentPicture);

        // Setting the textview elements with new values of the list
        studentName.setText(" " + post.poster);
        postTitle.setText(" " + post.naam);
        //studentPoint.setText(" " + post.punt);
        studentBeschrijving.setText(" " + post.beschrijving);
        studentPicture.setImageResource(post.foto);

        createAwnserToPost();

    }

    public void createAwnserToPost() {
        btnCreateAwnser = (ImageButton) findViewById(R.id.createAwnser);
        btnCreateAwnser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), Reactie.class);
                startActivity(intent);
            }
        });
    }

    public String readFromFile(Activity activity) {
        String read = "";
        //lv = (ListView)findViewById(R.id.listViewAwnsers);// TODO RETURNS NULL -.-
        try {
            InputStream input = openFileInput("QstudentData.txt");
            if (input != null) {
                InputStreamReader reader = new InputStreamReader(input);
                BufferedReader breader = new BufferedReader(reader);
                String receiveInfo = "";
                ArrayList<String> awnsers = new ArrayList<>();


                while ((receiveInfo = breader.readLine()) != null) {
                    String[] lines = receiveInfo.split(";");
                    String studentAwnser;
                    String studentName;
                    String studentPicture;
                    for (String s : lines) {
                        messageAwnser = (TextView) findViewById(R.id.postStudentAwnserQuestionText);
                        studentAwnser = lines[0];
                        studentName = lines[1];
                        studentPicture = lines[2];

                        messageAwnser.setText(studentAwnser);
                        name = (TextView) findViewById(R.id.postStudentAwnserQuestionName);
                        name.setText(studentName);
                        picture = (ImageView) findViewById(R.id.postStudentAwnserQuestionPicture);
                        picture.setImageResource(Integer.parseInt(studentPicture));
                    }
                    awnsers.addAll(Arrays.asList(lines));
                }

                input.close();
                awnserAdapter = new ArrayAdapter<String>(this, R.layout.content_postlist_list, awnsers);
                awnserAdapter.add("hoi");
                //listView.setAdapter(awnserAdapter); //TODO IS NULL -.-
            }
        } catch (IOException e) {
            System.out.println("Error message: " + e.toString());
        }

        return read;
    }

}
