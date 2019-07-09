package com.example.gestionmateriel.presentation.detailclient;
import android.view.View;
import android.widget.TextView;


import androidx.recyclerview.widget.RecyclerView;

import com.example.gestionmateriel.R;
import com.example.gestionmateriel.entite.Client;

public class ListeClientsViewHolder extends RecyclerView.ViewHolder {
    private TextView textViewView2;
    private TextView textViewView3;
    private TextView textViewView4;

    //itemView est la vue correspondante à 1 cellule
    public ListeClientsViewHolder(View itemView) {
        super(itemView);

        //c'est ici que l'on fait nos findView

        textViewView2 = (TextView) itemView.findViewById(R.id.nom);
        textViewView3 = (TextView) itemView.findViewById(R.id.nbContact);
        textViewView4 = (TextView) itemView.findViewById(R.id.nbMateriel);
    }

    //puis ajouter une fonction pour remplir la cellule en fonction d'un MyObject
    public void bind(Client client){
        textViewView2.setText(client.getNom());
        textViewView3.setText("0");
        textViewView4.setText("0");


    }
}

