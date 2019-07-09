package com.example.gestionmateriel.presentation.listclient;


import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.gestionmateriel.R;
import com.example.gestionmateriel.entite.Client;

import java.util.ArrayList;
import java.util.List;

public class ListeClients extends Fragment {

   /* private RecyclerView recyclerView;

    private List<Client> clients = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_client);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        //remplir la ville
        ajouterClient();

        recyclerView = (RecyclerView)findViewById(R.id.recyclerView);
        //définit l'agencement des cellules, ici de façon verticale, comme une ListView
        //recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.setLayoutManager());

        //pour adapter en grille comme une RecyclerView, avec 2 cellules par ligne
        //recyclerView.setLayoutManager(new (this,2));
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        //puis créer un MyAdapter, lui fournir notre liste de villes.
        //cet adapter servira à remplir notre recyclerview
        recyclerView.setAdapter(new ListeClientsAdapter(clients) {
        });
        Log.i("test","test"+  clients.toString() );
    }

    private void ajouterClient() {
        clients.add(new Client(1,"Robert","1 rue de la galette","Roubais"));
        clients.add(new Client(1,"Bruce lee","3 rue du riz","Tokyo"));

    }*/
}
