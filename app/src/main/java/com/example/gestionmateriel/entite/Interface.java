package com.example.gestionmateriel.entite;

public class Interface {
    private int id;
    private String nom;
    private String mac;
    private int idType;
    private int idMateriel;

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

    public String getMac() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac;
    }

    public int getIdType() {
        return idType;
    }

    public void setIdType(int idType) {
        this.idType = idType;
    }

    public int getIdMateriel() {
        return idMateriel;
    }

    public void setIdMateriel(int idMateriel) {
        this.idMateriel = idMateriel;
    }
}
