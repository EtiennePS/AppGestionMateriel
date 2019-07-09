package com.example.gestionmateriel.repository;

import com.example.gestionmateriel.entite.Client;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.List;

public class ClientRepository {

    private List<Client> clients;
    private static ClientRepository instance;

    private ClientRepository() { }

    public static ClientRepository getInstance() {
        if(instance == null) {
            instance = new ClientRepository();
        }
        return instance;
    }

    public List<Client> jsonToClients(String json) throws IOException {
        this.clients = new ObjectMapper().readValue(json, new TypeReference<List<Client>>(){});
        return clients;
    }

    public Client getById(int id) {
        for(int i = 0; i < clients.size(); i++) {
            if(clients.get(i).getId() == id) {
                return clients.get(i);
            }
        }
        return null;
    }

    public List<Client> getAll() {
        return clients;
    }


}
