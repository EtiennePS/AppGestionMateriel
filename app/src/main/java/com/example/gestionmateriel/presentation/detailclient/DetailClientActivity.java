package com.example.gestionmateriel.presentation.detailclient;

import android.os.Bundle;

import com.example.gestionmateriel.R;
import com.example.gestionmateriel.entite.Client;
import com.example.gestionmateriel.repository.ClientRepository;
import com.google.android.material.tabs.TabLayout;

import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import android.widget.Toast;

public class DetailClientActivity extends AppCompatActivity {
    private Client client;
    public Client getClient() {
        return client;
    }

    private void setClient(Client client) {
        this.client = client;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_client);
        DetailClientAdapter detailClientAdapter = new DetailClientAdapter(this, getSupportFragmentManager());
        ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(detailClientAdapter);
        TabLayout tabs = findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);

        ClientRepository cr = ClientRepository.getInstance();
        this.client  = cr.getById(getIntent().getIntExtra("idClient", 0));
    }
}