package com.example.gestionmateriel.presentation.ajoutclient;

import android.os.Bundle;

import com.example.gestionmateriel.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class AjoutClientActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajout_client);

        Button btAjouter = (Button) findViewById(R.id.boutonAjouterClient);
        btAjouter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(AjoutClientActivity.this, "Non Implémenté", Toast.LENGTH_SHORT).show();
            }
        });
    }

}
