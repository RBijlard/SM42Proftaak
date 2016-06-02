package com.example.roel.qstudent;

import java.util.List;

/**
 * Created by Roel on 02/06/2016.
 */
public class Onderdeel {
    private String naam;
    private List<Post> posts;
    private Vak vak;

    public Onderdeel(String naam, List<Post> posts, Vak vak) {
        this.naam = naam;
        this.posts = posts;
        this.vak = vak;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    public Vak getVak() {
        return vak;
    }

    public void setVak(Vak vak) {
        this.vak = vak;
    }
}
