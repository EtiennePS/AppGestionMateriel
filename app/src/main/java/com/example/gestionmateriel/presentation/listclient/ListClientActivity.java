package com.example.gestionmateriel.presentation.listclient;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.example.gestionmateriel.R;
import com.example.gestionmateriel.entite.Client;
import com.example.gestionmateriel.presentation.detailclient.ListeClientsAdapter;
import com.example.gestionmateriel.service.RequestMaker;

import java.util.ArrayList;
import java.util.List;

public class ListClientActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    private List<Client> clients = new ArrayList<>();

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_client);
        ajouterClient();
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        recyclerView.setAdapter(new ListeClientsAdapter(clients) {
        });
        Log.i("test","test"+  clients.toString() );

        update();
    }

    private void ajouterClient() {
        clients.add(new Client(1,"Robert","1 rue de la galette","Roubais"));
        clients.add(new Client(2,"Bruce lee","3 rue du riz","Tokyo"));
        clients.add(new Client(3,"Jason","4 avenue  des ribambelles","Paris"));
        clients.add(new Client(4,"Neil Armstrong","5 impasse du vésuve","Boutille"));
        clients.add(new Client(5,"Ronnie Schneider","3 rue du riz","Tokyo"));

    }
    public void run() {
        Intent mainIntent = new Intent(this, ListClientActivity.class);
        startActivity(mainIntent);
        finish();
    }

    private void update() {

        Response.Listener<String> rl = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.d("TEST", response);
                Toast.makeText(ListClientActivity.this, response, Toast.LENGTH_SHORT).show();
            }
        };

        Response.ErrorListener rel = new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(ListClientActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        };

        RequestMaker rm = new RequestMaker();
        rm.requestCombinedJSON(getApplicationContext(), rl, rel);
    }
}
