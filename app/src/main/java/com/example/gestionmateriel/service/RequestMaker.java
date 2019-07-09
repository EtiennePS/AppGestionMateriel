package com.example.gestionmateriel.service;

import android.content.Context;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;
import com.example.gestionmateriel.repository.CustomVolleyRequestQueue;

public class RequestMaker {

    public void requestCombinedJSON(Context c, Response.Listener<String> r, Response.ErrorListener e) {
        String url = "http://formation.devatom.net/UDEV2/ProjetFilRouge/JSON/combined/clients_contacts.json";
        StringRequest request = new StringRequest(Request.Method.GET, url, r, e);
        addRequest(request, c);
    }

    private void addRequest(Request r, Context c) {
        r.setRetryPolicy(new DefaultRetryPolicy(10000, 1, 1.0f));

        CustomVolleyRequestQueue.getInstance(c).getRequestQueue().add(r);
    }

}
