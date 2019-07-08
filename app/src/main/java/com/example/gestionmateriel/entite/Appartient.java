package com.example.gestionmateriel.entite;

public class Appartient {
    private int id;
    private Client idclient;
    private Fonction idfonction;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Client getIdclient() {
        return idclient;
    }

    public void setIdclient(Client idclient) {
        this.idclient = idclient;
    }

    public Fonction getIdfonction() {
        return idfonction;
    }

    public void setIdfonction(Fonction idfonction) {
        this.idfonction = idfonction;
    }
}
