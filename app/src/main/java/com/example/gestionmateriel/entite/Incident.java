package com.example.gestionmateriel.entite;

import java.util.Date;

public class Incident {
    private int id;
    private String libelle;
    private String symptome;
    private String resolution;
    private Date dateCreation;
    private Date dateCloture;
    private Status status;

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

    public String getSymptome() {
        return symptome;
    }

    public void setSymptome(String symptome) {
        this.symptome = symptome;
    }

    public String getResolution() {
        return resolution;
    }

    public void setResolution(String resolution) {
        this.resolution = resolution;
    }

    public Date getDateCreation() { return dateCreation; }

    public void setDateCreation(Date dateCreation) { this.dateCreation = dateCreation; }

    public Date getDateCloture() { return dateCloture; }

    public void setDateCloture(Date dateCloture) { this.dateCloture = dateCloture; }

    public Status getStatus() { return status; }

    public void setStatus(Status status) { this.status = status; }
}
