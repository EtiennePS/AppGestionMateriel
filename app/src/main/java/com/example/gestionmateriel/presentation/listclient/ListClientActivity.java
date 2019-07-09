package com.example.gestionmateriel.presentation.listclient;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;

import com.example.gestionmateriel.R;
import com.example.gestionmateriel.entite.Client;
import com.example.gestionmateriel.presentation.detailclient.ListeClientsAdapter;
import com.example.gestionmateriel.service.RequestMaker;

import java.util.ArrayList;
import java.util.List;

public class ListClientActivity extends AppCompatActivity {

   /* @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_client);

        update();
    }

    private void update() {

        Response.Listener<String> rl = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                TextView tv = (TextView) findViewById(R.id.testRequete);
                tv.setText(response);
            }
        };

        Response.ErrorListener rel = new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                TextView tv = (TextView) findViewById(R.id.testRequete);
                tv.setText(error.getMessage());
            }
        };

        RequestMaker rm = new RequestMaker();
        rm.requestCombinedJSON(getApplicationContext(), rl, rel);
    }*/

    private RecyclerView recyclerView;

    private List<Client> clients = new ArrayList<>();

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_client);
        ajouterClient();
        recyclerView = (RecyclerView)findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));



        recyclerView.setAdapter(new ListeClientsAdapter(clients) {
        });
        Log.i("test","test"+  clients.toString() );
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
}
