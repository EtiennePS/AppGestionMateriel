package com.example.gestionmateriel.presentation.listclient;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.example.gestionmateriel.R;
import com.example.gestionmateriel.entite.Client;
import com.example.gestionmateriel.presentation.ajoutclient.AjoutClientActivity;
import com.example.gestionmateriel.presentation.detailclient.DetailClientActivity;
import com.example.gestionmateriel.presentation.fichemateriel.FicheMaterielActivity;
import com.example.gestionmateriel.repository.ClientRepository;
import com.example.gestionmateriel.repository.MaterielRepository;
import com.example.gestionmateriel.service.RequestMaker;
import com.google.android.material.floatingactionbutton.FloatingActionButton;


import java.io.IOException;
import java.util.List;

public class ListClientActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_client);
        setTitle(R.string.title_activity_liste_client);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { ajouterClient(); }
        });

        update();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_list_client, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menulistclientupdate:
                update();
                return true;
            case R.id.menulistclientajouter:
                ajouterClient();
                return true;
            case R.id.menulistclientscanner:
                scanner();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void ajouterClient() {
        Intent i = new Intent(ListClientActivity.this, AjoutClientActivity.class);
        startActivity(i);
    }

    /**
     * Enclenche la mise à jour des données de la liste
     */
    private void update() {

        Response.Listener<String> rl = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                ClientRepository cr = ClientRepository.getInstance();
                try {
                    cr.importJSON(response);
                    updateList(cr.getAll());
                } catch (IOException e) {
                    e.printStackTrace();
                    Log.e("JSON", e.getMessage());
                    Toast.makeText(ListClientActivity.this, "Erreur : " + e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        };

        Response.ErrorListener rel = new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("JSON", error.getMessage());
                Toast.makeText(ListClientActivity.this, "ERREUR : " + error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        };

        RequestMaker rm = new RequestMaker();
        rm.requestCombinedJSON(getApplicationContext(), rl, rel);
    }

    private void updateList(List<Client> clients) {
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new ListeClientsAdapter(clients) {});

        if(getIntent().getDataString() != null)
            goToFicheMateriel();
    }

    private void goToFicheMateriel() {
        try {
            String data = getIntent().getDataString();
            int idMateriel = Integer.parseInt(data.substring(data.lastIndexOf('/') + 1));

            Log.d("ID", idMateriel + "");

            // On retire les données de l'intent pour éviter de revenir sur la fiche matériel par accident
            getIntent().setData(null);

            if(MaterielRepository.getInstance().getById(idMateriel) != null) {
                Intent i = new Intent(ListClientActivity.this, FicheMaterielActivity.class);
                i.putExtra("idMateriel", idMateriel);
                startActivity(i);
            }
            else {
                Toast.makeText(ListClientActivity.this, "Id non existant : " + idMateriel, Toast.LENGTH_SHORT).show();
            }


        }
        catch (NumberFormatException e) {
            Toast.makeText(ListClientActivity.this, "Id non valide : " + getIntent().getDataString(), Toast.LENGTH_SHORT).show();
        }
    }

    private void scanner() {
        Toast.makeText(ListClientActivity.this, "Non implémenté", Toast.LENGTH_SHORT).show();
    }


    private class ListeClientsViewHolder extends RecyclerView.ViewHolder {
        private TextView tvNomClient;
        private TextView tvNbContactClient;
        private TextView tvNbMaterielClient;
        private Client client;

        public View view;
        //itemView est la vue correspondante à 1 cellule
        public ListeClientsViewHolder(final View itemView) {
            super(itemView);

            //c'est ici que l'on fait nos findView

            tvNomClient = (TextView) itemView.findViewById(R.id.nom);
            tvNbContactClient = (TextView) itemView.findViewById(R.id.nbContact);
            tvNbMaterielClient = (TextView) itemView.findViewById(R.id.nbMateriel);

            view = itemView;
            view.setOnClickListener(new View.OnClickListener() {
                @Override public void onClick(View v) {
                    Intent myIntent = new Intent(ListClientActivity.this, DetailClientActivity.class);
                    myIntent.putExtra("idClient", client.getId());
                    startActivity(myIntent);
                }
            });
        }

        //puis ajouter une fonction pour remplir la cellule en fonction d'un MyObject
        public void bind(Client client){
            tvNomClient.setText(client.getNom());
            tvNbContactClient.setText(client.getNbContact() + "");
            tvNbMaterielClient.setText(client.getNbMateriel() + "");
            this.client = client;
        }
    }

    private  class ListeClientsAdapter extends RecyclerView.Adapter<ListeClientsViewHolder>
    {
        List<Client> list;
        public ListeClientsAdapter(List<Client> list) {
            this.list = list;
        }



        @Override
        public ListeClientsViewHolder onCreateViewHolder(ViewGroup viewGroup, int itemType) {
            View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.liste_client_layout,viewGroup,false);
            return new ListeClientsViewHolder(view);
        }

        public void onBindViewHolder(ListeClientsViewHolder myViewHolder, int position) {
            Client client = list.get(position);
            myViewHolder.bind(client);
        }
        @Override
        public int getItemCount() {
            return list.size();
        }

    }
    

}


