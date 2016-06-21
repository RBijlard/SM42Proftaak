package com.example.roel.qstudent.Models;

import java.io.Serializable;

/**
 * Created by Roel on 02/06/2016.
 */
public class Bericht implements Serializable{
    public String posterName;
    public String inhoud;
    public int posterPicture;
    public int upvote;
    public int downvote;
    public int punten;

    public Bericht(String posterName, String inhoud, int posterPicture, int upvote, int downvote) {
        this.posterName = posterName;
        this.inhoud = inhoud;
        this.posterPicture = posterPicture;
        this.upvote = upvote;
        this.downvote = downvote;
    }

    public String getPostName() {
        return posterName;
    }

    public String getInhoud() {
        return inhoud;
    }

    public void setInhoud(String inhoud) {
        this.inhoud = inhoud;
    }

    public int getPoster() {
        return posterPicture;
    }

    public void setPoster(int posterPicture) {
        this.posterPicture = posterPicture;
    }

    @Override
    public String toString(){
        String info = posterName + " " + inhoud + " " + posterPicture;
        return info;
    }
}
