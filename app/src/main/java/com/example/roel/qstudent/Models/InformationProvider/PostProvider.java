package com.example.roel.qstudent.Models.InformationProvider;

import android.content.Context;
import com.example.roel.qstudent.Models.Bericht;
import com.example.roel.qstudent.Models.Post;
import com.example.roel.qstudent.Models.Student;
import com.example.roel.qstudent.R;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Maxime on 3-6-2016.
 */
public class PostProvider {
    private static List<Post> postList;
    private Context context;

    public PostProvider(Context context){
        this.context = context;
    }

    public static Post getPost(int index){
        if(index >= postList.size()){
            return null;
        }
        return postList.get(index);
    }

    public void getPosts(){//String naam, String poster ,List<Bericht> berichten, int foto){
        postList = new ArrayList<Post>();

        String[] postName = context.getResources().getStringArray(R.array.studentPostTitle);
        String[] postStudent = context.getResources().getStringArray(R.array.studentPost);
        String[] postStudentPoints = context.getResources().getStringArray(R.array.studentPoints);
        String[] studentPostDescription = context.getResources().getStringArray(R.array.studentPostDescription);
        int[] studentFoto = new int[]{
                R.mipmap.bertsmit,
                R.mipmap.yousefadador,
                R.mipmap.claudiapols,
                R.mipmap.sarahjanssen
        };

        for(int studentIndex = 0; studentIndex < postName.length; studentIndex++){
            Post post = new Post();//naam, poster, berichten, foto);
            post.naam = postName[studentIndex];
            post.poster = postStudent[studentIndex];
            post.punt = postStudentPoints[studentIndex];
            post.beschrijving = studentPostDescription[studentIndex];
            post.setFoto(studentFoto[studentIndex]);

            postList.add(post);
        }
    }
}
