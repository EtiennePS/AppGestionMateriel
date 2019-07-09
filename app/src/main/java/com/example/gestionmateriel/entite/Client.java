package com.example.gestionmateriel.entite;

public class Client {
    private int id;
    private String nom;
    private String adresse1;
    private String adresse2;
    private Ville idcpville;

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
        return idcpville;
    }

    public void setVille(Ville ville) {
        this.idcpville = ville;
    }
}
