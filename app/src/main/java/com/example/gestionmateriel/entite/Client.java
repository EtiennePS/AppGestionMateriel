package com.example.gestionmateriel.entite;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class Client {

    public Client() {
        this.setMateriels(new ArrayList<Materiel>());
        this.setContacts(new ArrayList<Contact>());
    }

    private int id;
    private String nom;
    private String adresse1;
    private String adresse2;
    private Ville ville;
    private List<Contact> contacts;
    private List<Materiel> materiels;

    public int getNbContact() {
        return this.contacts.size();
    }

    public int getNbMateriel() {
        return this.materiels.size();
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

    public List<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(List<Contact> contacts) {
        this.contacts = contacts;
    }

    public List<Materiel> getMateriels() { return materiels; }

    public void setMateriels(List<Materiel> materiels) { this.materiels = materiels; }
}
