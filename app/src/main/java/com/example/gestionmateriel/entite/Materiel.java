package com.example.gestionmateriel.entite;

import java.util.List;

public class Materiel {
    private int id;
    private String libelle;
    private String numSerie;
    private TypeMateriel type;
    private List<Interface> interfaces;

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

    public TypeMateriel getTypeMateriel() {
        return type;
    }

    public void setTypeMateriel(TypeMateriel typeMateriel) {
        this.type = typeMateriel;
    }

    public List<Interface> getInterfaces() { return interfaces; }

    public void setInterfaces(List<Interface> interfaces) { this.interfaces = interfaces; }

    public String getNumSerie() {
        return numSerie;
    }

    public void setNumSerie(String numSerie) {
        this.numSerie = numSerie;
    }
}
