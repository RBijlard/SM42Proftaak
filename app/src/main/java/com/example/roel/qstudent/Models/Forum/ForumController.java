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
        retrieveFromNetwork();

        //Mock Data
        onderdelen.add(new Onderdeel("Presentatie",null));
        onderdelen.add(new Onderdeel("Opdrachten",null));
        onderdelen.add(new Onderdeel("Overige",null));
        vakken.add(new Vak("SM42",onderdelen));
        vakken.add(new Vak("JSF31",null));
        semesters.add(new Semester("S31",vakken));
        semesters.add(new Semester("S32",null));
    }

    private void retrieveFromNetwork() {

        Response.Listener<JSONObject> successListener = new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                parseJsonObjectToObject(response);
            }
        };

        Response.ErrorListener errorListener = new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        };

        String url = JSONurl; // http://www.somesite.com/somejson.json
        int method = Request.Method.GET;
        JSONObject request = null;

        JsonObjectRequest jsObjRequest = new JsonObjectRequest(method, url, request,
                successListener, errorListener);

        RequestQueue queue = Volley.newRequestQueue(context);
        queue.add(jsObjRequest);
    }


    private void parseJsonObjectToObject(JSONObject jsonobject) {
        try {
            JSONArray jsonArray = jsonobject.getJSONArray("Presentatie");
            int numberOfPosts = jsonArray.length();
            for (int i = 0; i < numberOfPosts; i++) {
                JSONObject jsonObjecti = jsonArray.getJSONObject(i);
                String titel;
                String inhoud;
                Student student = null;
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Onderdeel> getOnderdelen() {
        return onderdelen;
    }

    public ArrayList<Semester> getSemesters() {
        return semesters;
    }

    public ArrayList<Vak> getVakken() {
        return vakken;
    }


}
