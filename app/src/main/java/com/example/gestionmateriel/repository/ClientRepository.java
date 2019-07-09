package com.example.gestionmateriel.repository;

import com.example.gestionmateriel.entite.Client;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.List;

public class ClientRepository {

    public List<Client> jsonToClients(String json) throws IOException {
        return new ObjectMapper().readValue(json, new TypeReference<List<Client>>(){});
    }

}
