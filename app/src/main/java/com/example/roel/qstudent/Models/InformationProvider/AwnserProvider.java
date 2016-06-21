package com.example.roel.qstudent.Models.InformationProvider;

import android.content.Context;

import com.example.roel.qstudent.Models.Bericht;
import com.example.roel.qstudent.Models.Post;
import com.example.roel.qstudent.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Maxime on 9-6-2016.
 */
public class AwnserProvider {
    private static List<Bericht> berichtList;
    private Context context;

    public AwnserProvider(Context context){
        this.context = context;
    }

    public static Bericht getAwnser(int index){
        if(index >= berichtList.size()){
            return null;
        }
        return berichtList.get(index);
    }

    public void getAwnsers(){//String naam, String poster ,List<Bericht> berichten, int foto){
        berichtList = new ArrayList<Bericht>();

        //String[] postName = context.getResources().getStringArray(R.array.studentPostTitle);
        String[] postStudent = context.getResources().getStringArray(R.array.studentPostAwnser);
        //String[] postStudentPoints = context.getResources().getStringArray(R.array.studentPointsAwnser);
        String[] studentPostDescription = context.getResources().getStringArray(R.array.studentPostDescriptionAwnser);
        int[] studentFoto = new int[]{
                R.mipmap.sarahjanssen,
                R.mipmap.yousefadador
        };
        int upvote = R.mipmap.upvote;
        int downvote = R.mipmap.downvote;


        for(int studentIndex = 0; studentIndex < postStudent.length; studentIndex++){
            Bericht bericht = new Bericht("", "", 0, 0, 0);//naam, poster, berichten, foto);
            //post.naam = postName[studentIndex];
            bericht.posterName = postStudent[studentIndex];
            bericht.inhoud = studentPostDescription[studentIndex];
            bericht.posterPicture = studentFoto[studentIndex];
            bericht.upvote = upvote;
            bericht.downvote = downvote;

            berichtList.add(bericht);
        }
    }
}
