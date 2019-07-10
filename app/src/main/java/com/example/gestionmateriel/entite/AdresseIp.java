package com.example.gestionmateriel.entite;

public class AdresseIp {
    private int id;
    private String ipV4;
    private String ipV6;
    private String masque;
    private TypeAffectation typeAffectation;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIpV4() {
        return ipV4;
    }

    public void setIpV4(String ipV4) {
        this.ipV4 = ipV4;
    }

    public String getIpV6() {
        return ipV6;
    }

    public void setIpV6(String ipV6) {
        this.ipV6 = ipV6;
    }

    public String getMasque() {
        return masque;
    }

    public void setMasque(String masque) {
        this.masque = masque;
    }

    public TypeAffectation getTypeAffectation() { return typeAffectation; }

    public void setTypeAffectation(TypeAffectation typeAffectation) { this.typeAffectation = typeAffectation; }
}
