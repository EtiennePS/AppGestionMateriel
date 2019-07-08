package com.example.gestionmateriel.entite;

public class Materiel {
    private int id;
    private String libelle;
    private Client idclient;
    private TypeMateriel idtype;

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

    public Client getClient() {
        return idclient;
    }

    public void setClient(Client client) {
        this.idclient = client;
    }

    public TypeMateriel getTypeMateriel() {
        return idtype;
    }

    public void setTypeMateriel(TypeMateriel typeMateriel) {
        this.idtype = typeMateriel;
    }



}
