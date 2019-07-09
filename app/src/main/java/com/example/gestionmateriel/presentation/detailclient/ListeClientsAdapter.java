package com.example.gestionmateriel.presentation.detailclient;



import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.example.gestionmateriel.R;
import com.example.gestionmateriel.entite.Client;

import java.util.List;

public  class ListeClientsAdapter extends RecyclerView.Adapter<ListeClientsViewHolder>
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
