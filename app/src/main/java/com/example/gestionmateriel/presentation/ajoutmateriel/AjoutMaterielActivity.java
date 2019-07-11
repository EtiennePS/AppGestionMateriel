package com.example.gestionmateriel.presentation.ajoutmateriel;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.gestionmateriel.R;

public class AjoutMaterielActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajout_materiel);
        setTitle(R.string.title_activity_ajout_materiel);

        Button btAjouter = (Button) findViewById(R.id.boutonAjouterMateriel);
        btAjouter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(AjoutMaterielActivity.this, "Non Implémenté", Toast.LENGTH_SHORT).show();
            }
        });
    }

}
