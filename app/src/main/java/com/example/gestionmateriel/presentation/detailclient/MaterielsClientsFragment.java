package com.example.gestionmateriel.presentation.detailclient;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gestionmateriel.R;
import com.example.gestionmateriel.entite.Client;
import com.example.gestionmateriel.entite.Materiel;

import java.util.List;

public class MaterielsClientsFragment extends Fragment {
    private RecyclerView recyclerViewMateriel;

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_materiels_clients_layout, container, false);
        DetailClientActivity activity = (DetailClientActivity) getActivity();
        Client c = activity.getClient();

        recyclerViewMateriel = (RecyclerView) root.findViewById(R.id.recyclerViewMateriel);
        recyclerViewMateriel.setLayoutManager(new LinearLayoutManager(activity));
        recyclerViewMateriel.setAdapter(new ListeMaterielAdapter(c.getMateriels()) {});
        return root;
    }

    private class MaterielViewHolder extends RecyclerView.ViewHolder {
        private Materiel materiel;
        private TextView libelleMat;
        private TextView numeroSer;


        //itemView est la vue correspondante à 1 cellule
        public MaterielViewHolder(final View itemView) {
            super(itemView);

            //c'est ici que l'on fait nos findView

            libelleMat = (TextView) itemView.findViewById(R.id.libellelistemateriel);
            numeroSer = (TextView) itemView.findViewById(R.id.numserielistemateriel);
        }

        public void bindMateriel(Materiel materiel) {
            libelleMat.setText(materiel.getLibelle());
            numeroSer.setText(materiel.getNumSerie());
            this.materiel = materiel;
        }
    }

    private class ListeMaterielAdapter extends RecyclerView.Adapter<MaterielViewHolder> {
        List<Materiel> listMateriel;
        public ListeMaterielAdapter(List<Materiel> list) {
            this.listMateriel= list;
        }



        @Override
        public MaterielViewHolder onCreateViewHolder(ViewGroup viewGroup, int itemType) {
            View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.liste_materiel_layout,viewGroup,false);
            return new MaterielViewHolder(view);
        }

        public void onBindViewHolder(MaterielViewHolder myViewHolder, int position) {
            Materiel materiel = listMateriel.get(position);
            myViewHolder.bindMateriel(materiel);
        }
        @Override
        public int getItemCount() {
            return listMateriel.size();
        }


    }
}






