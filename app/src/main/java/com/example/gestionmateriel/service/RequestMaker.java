package com.example.gestionmateriel.service;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;
import com.example.gestionmateriel.repository.CustomVolleyRequestQueue;

public class RequestMaker {

    public void requestCombinedJSON(Context c, Response.Listener<String> r, Response.ErrorListener e) {
        RequestQueue queue = CustomVolleyRequestQueue.getInstance(c).getRequestQueue();
        String url ="https://www.devatom.net/UDEV2/ProjetFilRouge/JSON/combined/clients_contacts.json";
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, r, e);
        queue.add(stringRequest);
    }

}
