package com.example.gestionmateriel.repository;

import com.example.gestionmateriel.entite.Client;
import com.example.gestionmateriel.entite.Materiel;

import java.util.List;

public class MaterielRepository {

    private static MaterielRepository instance;
    private MaterielRepository() { }

    public static MaterielRepository getInstance() {
        if(instance == null) {
            instance = new MaterielRepository();
        }
        return instance;
    }

    public Materiel getById(int id) {
        ClientRepository cr = ClientRepository.getInstance();

        for(  Client c:cr.getAll()) {
            for(Materiel m : c.getMateriels()) {
                if (m.getId() == id){
                    return m;
                }
            }
        }

        return null;
    }

}
