package com.example.gestionmateriel.entite;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Contact {

    private int id;
    private Personne personne;
    private Fonction fonction;

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public Personne getPersonne() { return personne; }

    public void setPersonne(Personne p) { this.personne = p; }

    public Fonction getFonction() {
        return fonction;
    }

    public void setFonction(Fonction fonction) {
        this.fonction = fonction;
    }
}
