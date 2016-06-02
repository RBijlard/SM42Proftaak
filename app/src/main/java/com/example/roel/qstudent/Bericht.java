package com.example.roel.qstudent;

/**
 * Created by Roel on 02/06/2016.
 */
public class Bericht {
    private String titel;
    private String inhoud;
    private Student poster;

    public Bericht(String titel, String inhoud, Student poster) {
        this.titel = titel;
        this.inhoud = inhoud;
        this.poster = poster;
    }

    public String getTitel() {
        return titel;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    public String getInhoud() {
        return inhoud;
    }

    public void setInhoud(String inhoud) {
        this.inhoud = inhoud;
    }

    public Student getPoster() {
        return poster;
    }

    public void setPoster(Student poster) {
        this.poster = poster;
    }
}
