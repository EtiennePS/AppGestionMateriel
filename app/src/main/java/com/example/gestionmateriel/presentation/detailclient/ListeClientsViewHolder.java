package com.example.gestionmateriel.presentation.detailclient;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.recyclerview.widget.RecyclerView;

import com.example.gestionmateriel.R;
import com.example.gestionmateriel.entite.Client;

public class ListeClientsViewHolder extends RecyclerView.ViewHolder {
    private TextView textViewView;
    private ImageView imageView;

    //itemView est la vue correspondante à 1 cellule
    public ListeClientsViewHolder(View itemView) {
        super(itemView);

        //c'est ici que l'on fait nos findView

        textViewView = (TextView) itemView.findViewById(R.id.text);
        imageView = (ImageView) itemView.findViewById(R.id.image);
    }

    //puis ajouter une fonction pour remplir la cellule en fonction d'un MyObject
    public void bind(Client client){
        textViewView.setText(client.getId());
        textViewView.setText(client.getNom());
        textViewView.setText(client.getAdresse1());
        textViewView.setText(client.getAdresse2());

    }
}

