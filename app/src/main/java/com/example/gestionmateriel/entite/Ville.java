package com.example.gestionmateriel.entite;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Ville {

    @JsonProperty("ville_id")
    private int id;

    @JsonProperty("ville_cp")
    private String codePostale;

    @JsonProperty("ville_nom")
    private String nom;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCodePostale() {
        return codePostale;
    }

    public void setCodePostale(String codePostale) {
        this.codePostale = codePostale;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String toString() {
        return getNom() + " " + getCodePostale();
    }
}
