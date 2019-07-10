package com.example.gestionmateriel.entite;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Contact {

    @JsonProperty("pers_id")
    private int id;

    @JsonProperty("pers_nom")
    private String nom;

    @JsonProperty("pers_prenom")
    private String prenom;

    @JsonProperty("pers_tel")
    private String telephone;

    @JsonProperty("pers_email")
    private String email;

    @JsonProperty("fonction")
    private Fonction fonction;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Fonction getFonction() {
        return fonction;
    }

    public void setFonction(Fonction fonction) {
        this.fonction = fonction;
    }
}
