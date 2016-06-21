package com.example.roel.qstudent.Activitys;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.roel.qstudent.Models.Bericht;
import com.example.roel.qstudent.Models.InformationProvider.AwnserProvider;
import com.example.roel.qstudent.Models.InformationProvider.CustomListviewAdapter;
import com.example.roel.qstudent.Models.InformationProvider.CustomListviewAdapterAwnser;
import com.example.roel.qstudent.Models.InformationProvider.PostProvider;
import com.example.roel.qstudent.Models.Post;
import com.example.roel.qstudent.R;
import com.example.roel.qstudent.Reactie;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class postAwnsers extends AppCompatActivity {
    private ImageButton btnCreateAwnser;
    private TextView messageAwnser;
    private ImageView picture;
    private TextView name;
    private Context context;
    private ImageButton btnUpvote;
    private ImageButton btnDownvote;
    //private List<Bericht> items = new ArrayList<>();
    private ArrayList<Bericht> berichten;
    private boolean hasMessage;
    private ArrayList<String> awnsers;
    private List<Bericht> items = new ArrayList<>();
    private ArrayList<Bericht> items2 = new ArrayList<>();
    private ListView listView;
    private int aantalAntwoorden = 0;
    // TODO AANTAL ANTWOORDEN MEGEVEN AAN DE VOORPAGINA VAN VRAGEN
    // TODO BESTE MANIER AAN TE PAKKEN DOOR PUTEXTRA MEE TE GEVEN EN GETEXTRA OM DE WAARDE OP TE HALEN.
    // TODO DIT VOOR ELK PERSOON DIE EEN VRAAG HEEFT.
    //private ArrayAdapter<String> awnserAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_postlist_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        context = this;

        // Getting the position number from the chosen post
        int postPosition = getIntent().getIntExtra("postPosition", 0);
        Post post  = PostProvider.getPost(postPosition);

        // Making text variables and bind them with and exisiting text ID.
        TextView postTitle = (TextView)findViewById(R.id.postTitle);
        TextView studentName = (TextView)findViewById(R.id.postStudentName);
        //TextView studentPoint = (TextView)findViewById(R.id.studentPoints);
        TextView studentBeschrijving = (TextView)findViewById(R.id.studentBeschrijving);
        ImageView studentPicture = (ImageView)findViewById(R.id.postStudentPicture);

        // Setting the textview elements with new values of the list
        studentName.setText(" " + post.poster);
        postTitle.setText(" " + post.naam);
        //studentPoint.setText(" " + post.punt);
        studentBeschrijving.setText(" " + post.beschrijving);
        studentPicture.setImageResource(post.foto);

        AwnserProvider awnserProvider = new AwnserProvider(this);
        awnserProvider.getAwnsers();

        listView = (ListView)findViewById(R.id.listViewAwnsers);
        switch (postPosition){
            case 0: getExistingMessagesBertSmit();
                break;
            case 1: getExistingMessagesYousefAdador();
                break;
            case 3: getExistingMessagesSarrahJanssen();
                break;
        }
        //readObjectFile();
        //readFromFile();

        CustomListviewAdapterAwnser adapter = new CustomListviewAdapterAwnser(this, items);
        listView.setAdapter(adapter);

        final String[] berichten = getResources().getStringArray(R.array.studentPostDescriptionAwnser);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String name = berichten[position];

                // TODO moet officieel naar de pagina gaan van de ingelogde gebruiker
                Intent intent = new Intent(parent.getContext(), PostList.class);
                intent.putExtra("postPosition", position);
                startActivity(intent);
            }
        });

        getMessages();
        createAwnserToPost();
        //upvotePost();
        //downvotePost();
    }

    public String readFromFile(){
        String read = "";
        //lv = (ListView)findViewById(R.id.listViewAwnsers);// TODO RETURNS NULL -.-
        try {
            InputStream input = openFileInput("QstudentData.txt");
            if(input != null){
                InputStreamReader reader = new InputStreamReader(input);
                BufferedReader breader = new BufferedReader(reader);
                String receiveInfo = "";
                awnsers = new ArrayList<>();


                while((receiveInfo = breader.readLine()) != null){
                    String[] lines = receiveInfo.split(";");
                    String studentAwnser;
                    String studentName;
                    String studentPicture;
                    for(String s : lines){

                        studentAwnser = lines[0];
                        studentName = lines[1];
                        studentPicture = lines[2];

                        messageAwnser = (TextView)findViewById(R.id.postStudentAwnserQuestionText);
                        messageAwnser.setText(studentAwnser);
                        name = (TextView)findViewById(R.id.postStudentAwnserQuestionName);
                        name.setText(studentName);
                        picture = (ImageView)findViewById(R.id.postStudentAwnserQuestionPicture);
                        picture.setImageResource(Integer.parseInt(studentPicture));
                    }
                    awnsers.addAll(Arrays.asList(lines));
                }

                input.close();
                //awnserAdapter = new ArrayAdapter<String>(this, R.layout.content_postlist_list, awnsers);
                //awnserAdapter.add("hoi");
                //listView.setAdapter(awnserAdapter); //TODO IS NULL -.-
            }
        }catch(IOException e){
            System.out.println("Error message: " + e.toString());
        }

        return read;
    }

    public void readObjectFile(){
        try {
            InputStream input = openFileInput("QstudentData2.txt");
            ObjectInputStream ois = new ObjectInputStream(input);

            ArrayList<Bericht> berichten = (ArrayList<Bericht>)ois.readObject();
            ois.close();

            for(Bericht b : berichten){
                messageAwnser = (TextView)findViewById(R.id.postStudentAwnserQuestionText);
                messageAwnser.setText(b.getInhoud());
                name = (TextView)findViewById(R.id.postStudentAwnserQuestionName);
                name.setText(b.getPostName());
                picture = (ImageView)findViewById(R.id.postStudentAwnserQuestionPicture);
                picture.setImageResource(b.posterPicture);
            }

        }catch(IOException e){
            System.out.println("Error message: " + e.toString());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
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

    public void getMessages(){
        Bericht bericht = (Bericht)getIntent().getSerializableExtra("getBerichten");
        if(bericht != null){
            items.add(bericht);
            CustomListviewAdapterAwnser adapter = new CustomListviewAdapterAwnser(this, items);
            listView.setAdapter(adapter);

            for(Bericht b : items){
                aantalAntwoorden ++;
                Intent intent = new Intent();
                intent.putExtra("aantalAntwoordenNieuweBerichten", aantalAntwoorden);
            }
        }
    }

    public void getExistingMessagesYousefAdador(){
        items.add(new Bericht("", "", 0, R.mipmap.upvote, R.mipmap.downvote){{
            posterPicture = R.mipmap.claudiapols;
            inhoud = "Project document bestaat uit 4 componenten. Het belangrijkste onderdeel is het compositie diagram";
            posterName = "Claudia Pols";
            upvote = R.mipmap.upvote;
            downvote = R.mipmap.downvote;
            punten = 20;
        }});
        items.add(new Bericht("", "", 0, R.mipmap.upvote, R.mipmap.downvote) {{
            posterPicture = R.mipmap.bertsmit;
            inhoud = "Yousef. Probeer tijdens het maken van het document goed te letten op de nederlandse taal.";
            posterName = "Bert Smit";
            upvote = R.mipmap.upvote;
            downvote = R.mipmap.downvote;
            punten = 3;
        }});
        items.add(new Bericht("", "", 0, R.mipmap.upvote, R.mipmap.downvote) {{
            posterPicture = R.mipmap.yousefadador;
            inhoud = "Allen bedankt voor jullie reacties maar ik heb het antwoord al gevonden!";
            posterName = "Yousef Adador";
            upvote = R.mipmap.upvote;
            downvote = R.mipmap.downvote;
            punten = 1;
        }});

        for(Bericht b : items){
            aantalAntwoorden ++;
            Intent intent = new Intent();
            intent.putExtra("aantalAntwoordenYousefAdador", aantalAntwoorden);
        }
    }

    public void getExistingMessagesSarrahJanssen(){
        items.add(new Bericht("", "", 0, R.mipmap.upvote, R.mipmap.downvote){{
            posterPicture = R.mipmap.bertsmit;
            inhoud = "Ik heb nog een oud project document staat op mijn pc. Als je wil kan je deze overnemen. Stuur me een persoonlijk bericht!";
            posterName = "Bert Smit";
            upvote = R.mipmap.upvote;
            downvote = R.mipmap.downvote;
            punten = 42;
        }});
        items.add(new Bericht("", "", 0, R.mipmap.upvote, R.mipmap.downvote) {{
            posterPicture = R.mipmap.yousefadador;
            inhoud = "Project document maken kan je het beste gezamenlijk doen. Het is namelijk erg veel werk. Succes ermee!";
            posterName = "Yousef Adador";
            upvote = R.mipmap.upvote;
            downvote = R.mipmap.downvote;
            punten = 7;
        }});

        for(Bericht b : items){
            aantalAntwoorden ++;
            Intent intent = new Intent();
            intent.putExtra("aantalAntwoordenSarahJanssen", aantalAntwoorden);
        }
    }

    public void getExistingMessagesBertSmit(){
        items.add(new Bericht("", "", 0, R.mipmap.upvote, R.mipmap.downvote){{
            posterPicture = R.mipmap.claudiapols;
            inhoud = "Er werken ong 4/5 man in een project. " +
                    "Ieder groepslid vervult hier een rol. Hopelijk heeft deze vraag je geholpen";
            posterName = "Claudia Pols";
            upvote = R.mipmap.upvote;
            downvote = R.mipmap.downvote;
            punten = 33;
        }});
        items.add(new Bericht("", "", 0, R.mipmap.upvote, R.mipmap.downvote) {{
            posterPicture = R.mipmap.sarahjanssen;
            inhoud = "Er werken 50 man in een proftaak";
            posterName = "Sarah Janssen";
            upvote = R.mipmap.upvote;
            downvote = R.mipmap.downvote;
            punten = -1;
        }});
        items.add(new Bericht("", "", 0, R.mipmap.upvote, R.mipmap.downvote) {{
            posterPicture = R.mipmap.yousefadador;
            inhoud = "Wat is een proftaak? Ik weet niet precies wat je met deze vraag bedoelt?";
            posterName = "Yousef Adador";
            upvote = R.mipmap.upvote;
            downvote = R.mipmap.downvote;
            punten = -3;
        }});

        for(Bericht b : items){
            aantalAntwoorden ++;
            Intent intent = new Intent();
            intent.putExtra("aantalAntwoordenBertSmit", aantalAntwoorden);
        }
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
