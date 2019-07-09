package com.example.gestionmateriel.entite;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Fonction {

    @JsonProperty("fct_id")
    private int id;

    @JsonProperty("fct_libelle")
    private String libelle;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
}
