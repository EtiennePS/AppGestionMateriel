package com.example.gestionmateriel.presentation.detailclient;

import android.content.Intent;
import android.os.Bundle;

import com.example.gestionmateriel.R;
import com.example.gestionmateriel.entite.Client;
import com.example.gestionmateriel.presentation.ajoutclient.AjoutClientActivity;
import com.example.gestionmateriel.repository.ClientRepository;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;

import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Toast;

public class DetailClientActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DetailClientAdapter detailClientAdapter = new DetailClientAdapter(this, getSupportFragmentManager());
        ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(detailClientAdapter);
        TabLayout tabs = findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);
        FloatingActionButton fab = findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                Intent i = new Intent(DetailClientActivity.this, AjoutClientActivity.class);
                startActivity(i);
            }
        });

        ClientRepository cr = ClientRepository.getInstance();
        Client c = cr.getById(getIntent().getIntExtra("idClient", 0));
        Toast.makeText(DetailClientActivity.this, c.getNom(), Toast.LENGTH_SHORT).show();
    }
}