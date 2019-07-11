package com.example.gestionmateriel.presentation.ajoutcontact;

import androidx.appcompat.app.AppCompatActivity;
import com.example.gestionmateriel.R;

import android.app.ActionBar;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class AjoutContactActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getFragmentManager().popBackStack();
        super.onCreate(savedInstanceState);
        //getActionBar().setDisplayHomeAsUpEnabled(true);
        setContentView(R.layout.activity_ajout_contact);
        setTitle(R.string.title_activity_ajout_contact);

         Button btAjouter = (Button) findViewById(R.id.buttonAjoutContact);
         btAjouter.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 Toast.makeText(AjoutContactActivity.this, "Non Implémenté", Toast.LENGTH_SHORT).show();
             }
         });
    }
}
