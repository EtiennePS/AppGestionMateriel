package com.example.gestionmateriel.repository;

import com.example.gestionmateriel.entite.Ville;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class VilleRepository {

    public List<Ville> getAll() throws IOException {
        ObjectMapper mapper = new ObjectMapper();

        // Read JSON file and convert to java object
        InputStream fileInputStream = new FileInputStream("clients_contacts.json");
        List<Ville> villes = mapper.readValue(fileInputStream, new TypeReference<List<Ville>>(){});
        fileInputStream.close();
        return villes;
    }



}
