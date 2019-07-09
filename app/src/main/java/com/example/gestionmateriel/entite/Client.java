package com.example.gestionmateriel.entite;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Client {

    @JsonProperty("clt_id")
    private int id;

    @JsonProperty("clt_nom")
    private String nom;

    @JsonProperty("clt_adr1")
    private String adresse1;

    @JsonProperty("clt_adr2")
    private String adresse2;

    @JsonProperty("ville")
    private Ville ville;

    @JsonProperty("contacts")
    private List<Personne> contacts;

    public Client(int id, String nom, String adresse1, String adresse2){
        this.id = id  ;
        this.nom = nom  ;
        this.adresse1 = adresse1  ;
        this.adresse2 = adresse2  ;
    }
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

    public String getAdresse1() {
        return adresse1;
    }

    public void setAdresse1(String adresse1) {
        this.adresse1 = adresse1;
    }

    public String getAdresse2() {
        return adresse2;
    }

    public void setAdresse2(String adresse2) {
        this.adresse2 = adresse2;
    }

    public Ville getVille() {
        return ville;
    }

    public void setVille(Ville ville) {
        this.ville = ville;
    }

    public List<Personne> getContacts() {
        return contacts;
    }

    public void setContacts(List<Personne> contacts) {
        this.contacts = contacts;
    }
}
