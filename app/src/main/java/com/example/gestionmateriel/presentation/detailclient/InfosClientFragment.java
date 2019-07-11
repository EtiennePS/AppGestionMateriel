package com.example.gestionmateriel.presentation.detailclient;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.gestionmateriel.R;
import com.example.gestionmateriel.entite.Client;
import com.example.gestionmateriel.repository.ClientRepository;

public class InfosClientFragment extends Fragment {

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_infos_client_layout, container, false);

        DetailClientActivity activity = (DetailClientActivity) getActivity();
        Client c = activity.getClient();

        TextView tvNom = (TextView) root.findViewById(R.id.societeinfoclient);
        tvNom.setText(c.getNom());

        TextView tvAdresse = (TextView) root.findViewById(R.id.adresseinfoclient);
        tvAdresse.setText(c.getAdresse1());

        TextView tvAdresse2 = (TextView) root.findViewById(R.id.adresse2infoclient);
        tvAdresse2.setText(c.getAdresse2());

        TextView tvCodePostal = (TextView) root.findViewById(R.id.codepostinfoclient);
        tvCodePostal.setText(c.getVille().getCodePostale());

        TextView tvVille = (TextView) root.findViewById(R.id.villeinfoclient);
        tvVille.setText(c.getVille().getNom());

        Button btAjouter = (Button) root.findViewById(R.id.boutonModifClient);
        btAjouter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "Non Implémenté", Toast.LENGTH_SHORT).show();
            }
        });

        return root;
    }

}
