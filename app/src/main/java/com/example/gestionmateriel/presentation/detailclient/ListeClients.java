package com.example.gestionmateriel.presentation.detailclient;


import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.gestionmateriel.R;
import com.example.gestionmateriel.entite.Client;

import java.util.ArrayList;
import java.util.List;

public class ListeClients extends AppCompatActivity {

    private RecyclerView recyclerView;

    private List<Client> clients = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        //remplir la ville
        ajouterClient();

        //recyclerView = (RecyclerView)findViewById(R.id.);
        //définit l'agencement des cellules, ici de façon verticale, comme une ListView
        //recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.setLayoutManager());

        //pour adapter en grille comme une RecyclerView, avec 2 cellules par ligne
        //recyclerView.setLayoutManager(new (this,2));

        //puis créer un MyAdapter, lui fournir notre liste de villes.
        //cet adapter servira à remplir notre recyclerview
        recyclerView.setAdapter(new ListeClientsAdapter(clients) {
        });
    }

    private void ajouterClient() {
        clients.add(new Client(1,"Robert","1 rue de la galette","Roubais"));
        clients.add(new Client(1,"Bruce lee","3 rue du riz","Tokyo"));

    }
}
