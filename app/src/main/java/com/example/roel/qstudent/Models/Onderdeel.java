package com.example.roel.qstudent.Models;

import java.util.List;

/**
 * Created by Roel on 02/06/2016.
 */
public class Onderdeel {
    private String naam;
    private List<Post> posts;

    public Onderdeel(String naam, List<Post> posts) {
        this.naam = naam;
        this.posts = posts;
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
}
