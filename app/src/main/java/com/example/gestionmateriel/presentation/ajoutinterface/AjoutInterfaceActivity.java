package com.example.gestionmateriel.presentation.ajoutinterface;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.gestionmateriel.R;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;

import android.view.View;
import android.widget.ArrayAdapter;

import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;


public class AjoutInterfaceActivity extends AppCompatActivity {
    Spinner spinner;
    Spinner spinner2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajout_interface);
        setTitle(R.string.title_activity_ajout_interface);

        Button btAjouter = (Button) findViewById(R.id.ajoutinterface);
        btAjouter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(AjoutInterfaceActivity.this, "Non Implémenté", Toast.LENGTH_SHORT).show();
            }
        });

        spinner = (Spinner) findViewById(R.id.typeajoutinterface);
        spinner2 =(Spinner) findViewById(R.id.affectationajoutinterface);

        List exempleList = new ArrayList();
        exempleList.add("wlan");
        exempleList.add("lan");
        exempleList.add("bluetooth");
        exempleList.add("wan");

        List exempleList2 = new ArrayList();
        exempleList2.add("DHCP");
        exempleList2.add("static");

        ArrayAdapter adapter = new ArrayAdapter(
                getApplicationContext(),
                android.R.layout.simple_spinner_dropdown_item,
                exempleList

        );

        ArrayAdapter adapter2 = new ArrayAdapter(
                getApplicationContext(),
                android.R.layout.simple_spinner_dropdown_item,
                exempleList2

        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(adapter);
        spinner2.setAdapter(adapter2);
    }

}
