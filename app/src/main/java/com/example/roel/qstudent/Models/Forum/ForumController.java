package com.example.roel.qstudent.Models.Forum;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.roel.qstudent.Models.Bericht;
import com.example.roel.qstudent.Models.Onderdeel;
import com.example.roel.qstudent.Models.Post;
import com.example.roel.qstudent.Models.Semester;
import com.example.roel.qstudent.Models.Student;
import com.example.roel.qstudent.Models.Vak;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by royti on 16-6-2016.
 */
public class ForumController {
    private static final String JSONurl = "https://api.myjson.com/bins/531if";

    Context context;
    ArrayList<Semester> semesters;
    ArrayList<Vak> vakken;
    ArrayList<Onderdeel> onderdelen;
    ArrayList<Post> posts;
    ArrayList<Bericht> berichten;

    public ForumController(Context context) {
        this.context = context;
//        retrieveFromNetwork();
        semesters = new ArrayList<>();
        vakken = new ArrayList<>();
        onderdelen = new ArrayList<>();
        posts = new ArrayList<>();
        berichten = new ArrayList<>();

        //Mock Data
        onderdelen.add(new Onderdeel("Presentatie", null));
        onderdelen.add(new Onderdeel("Opdrachten", null));
        onderdelen.add(new Onderdeel("Overige", null));
        vakken.add(new Vak("SM42", onderdelen));
        vakken.add(new Vak("JSF31", null));
        semesters.add(new Semester("S31", vakken));
        semesters.add(new Semester("S32", null));
    }

    public ArrayList<Vak> getVakken() {
        return vakken;
    }

    public void setVakken(ArrayList<Vak> vakken) {
        this.vakken = vakken;
    }

    public ArrayList<Post> getPosts() {
        return posts;
    }

    public void setPosts(ArrayList<Post> posts) {
        this.posts = posts;
    }

    public ArrayList<Semester> getSemesters() {
        return semesters;
    }

    public void setSemesters(ArrayList<Semester> semesters) {
        this.semesters = semesters;
    }

    public ArrayList<Onderdeel> getOnderdelen() {
        return onderdelen;
    }

    public void setOnderdelen(ArrayList<Onderdeel> onderdelen) {
        this.onderdelen = onderdelen;
    }

    public void addVakken(Vak v) {
        vakken.add(v);
    }

    public void addSemester(Semester s) {
        semesters.add(s);
    }

    public void addOnderdeel(Onderdeel o) {
        onderdelen.add(o);
    }

    public ArrayList<Vak> getVakkenBijSemester(String semester) {
        for (Semester s : semesters) {
            if (s.getNaam().equals("semester")) {
                return (ArrayList<Vak>) s.getVakken();
            }
        }
        return null;
    }

    public ArrayList<Onderdeel> getOnderdeelBijVak(String vak) {
        for (Vak v : vakken) {
            if (v.toString().equals(vak)) {
                return (ArrayList<Onderdeel>) v.getOnderdelen();
            }
        }
        return null;
    }

    public ArrayList<Post> getPostsBijOnderdeel(String onderdeel) {

        for (Onderdeel o : onderdelen) {
            if (o.toString().equals(onderdeel)) {
                return (ArrayList<Post>) o.getPosts();
            }
        }
        return null;
    }

    public ArrayList<Bericht> getBerichtenBijPosts(String post) {
        for (Post p : posts) {
            if (p.toString().equals(post)) {
                return (ArrayList<Bericht>) p.berichten;
            }
        }
        return null;
    }

//    private void retrieveFromNetwork() {
//
//        Response.Listener<JSONObject> successListener = new Response.Listener<JSONObject>() {
//            @Override
//            public void onResponse(JSONObject response) {
//                parseJsonObjectToObject(response);
//            }
//        };
//
//        Response.ErrorListener errorListener = new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                error.printStackTrace();
//            }
//        };
//
//        String url = JSONurl; // http://www.somesite.com/somejson.json
//        int method = Request.Method.GET;
//        JSONObject request = null;
//
//        JsonObjectRequest jsObjRequest = new JsonObjectRequest(method, url, request,
//                successListener, errorListener);
//
//        RequestQueue queue = Volley.newRequestQueue(context);
//        queue.add(jsObjRequest);
//    }

//
//    private void parseJsonObjectToObject(JSONObject jsonobject) {
//        try {
//            JSONArray jsonArray = jsonobject.getJSONArray("Presentatie");
//            int numberOfPosts = jsonArray.length();
//            for (int i = 0; i < numberOfPosts; i++) {
//                JSONObject jsonObjecti = jsonArray.getJSONObject(i);
//                String titel;
//                String inhoud;
//                Student student = null;
//            }
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
//    }


}
