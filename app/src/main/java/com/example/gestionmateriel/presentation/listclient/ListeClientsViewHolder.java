package com.example.gestionmateriel.presentation.listclient;
import android.view.View;
import android.widget.TextView;


import androidx.recyclerview.widget.RecyclerView;

import com.example.gestionmateriel.R;
import com.example.gestionmateriel.entite.Client;

public class ListeClientsViewHolder extends RecyclerView.ViewHolder {
    private TextView tvNomClient;
    private TextView tvNbContactClient;
    private TextView tvNbMaterielClient;

    //itemView est la vue correspondante à 1 cellule
    public ListeClientsViewHolder(View itemView) {
        super(itemView);

        //c'est ici que l'on fait nos findView

        tvNomClient = (TextView) itemView.findViewById(R.id.nom);
        tvNbContactClient = (TextView) itemView.findViewById(R.id.nbContact);
        tvNbMaterielClient = (TextView) itemView.findViewById(R.id.nbMateriel);
    }

    //puis ajouter une fonction pour remplir la cellule en fonction d'un MyObject
    public void bind(Client client){
        tvNomClient.setText(client.getNom());
        tvNbContactClient.setText(client.getNbContact() + "");
        tvNbMaterielClient.setText("0");
    }
}

