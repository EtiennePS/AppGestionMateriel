package com.example.gestionmateriel.repository;

import com.example.gestionmateriel.entite.AdresseIp;
import com.example.gestionmateriel.entite.Client;
import com.example.gestionmateriel.entite.Contact;
import com.example.gestionmateriel.entite.Fonction;
import com.example.gestionmateriel.entite.Interface;
import com.example.gestionmateriel.entite.Materiel;
import com.example.gestionmateriel.entite.TypeAffectation;
import com.example.gestionmateriel.entite.TypeInterface;
import com.example.gestionmateriel.entite.TypeMateriel;
import com.example.gestionmateriel.entite.Ville;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ClientRepository {

    private List<Client> clients;
    private static ClientRepository instance;

    private ClientRepository() { }

    public static ClientRepository getInstance() {
        if(instance == null) {
            instance = new ClientRepository();
        }
        return instance;
    }

    public List<Client> importJSON(String json) throws IOException {
        this.clients = new ObjectMapper().readValue(json, new TypeReference<List<Client>>(){});
        return clients;
    }

    public Client getById(int id) {
        for(int i = 0; i < clients.size(); i++) {
            if(clients.get(i).getId() == id) {
                return clients.get(i);
            }
        }
        return null;
    }

    public List<Client> getAll() {
        return clients;
    }

    public void addExempleClient() {
        Client c = new Client();

        TypeAffectation ta = new TypeAffectation();
        TypeMateriel tm = new TypeMateriel();
        TypeInterface ti = new TypeInterface();
        AdresseIp ai = new AdresseIp();
        Interface i = new Interface();
        Materiel m = new Materiel();

        ta.setLibelle("DHCP");
        ti.setLibelle("Bluetooth");
        tm.setLibelle("Téléphone");

        ai.setIpV4("192.168.0.1");
        ai.setIpV6("5f7a::5db7:36a7:eb9a");
        ai.setMasque("255.255.255.0");
        ai.setTypeAffectation(ta);

        i.setTypeInterface(ti);
        i.setAdresseIp(ai);
        i.setMac("6864646463");
        i.setNom("GigaByte 3500");

        m.setTypeMateriel(tm);
        m.setId(357);
        m.setLibelle("Xiaomi Redmi Note 4");
        m.setInterfaces(new ArrayList<Interface>());
        m.getInterfaces().add(i);


        // Partie info client
        Fonction f = new Fonction();
        Contact co = new Contact();
        Ville v = new Ville();

        v.setCodePostale("33000");
        v.setNom("Bordeaux");

        f.setLibelle("Xtrem Programmeur");

        co.setNom("LAURIN");
        co.setPrenom("Maxime");
        co.setEmail("17.laurinmaxime@gmail.com");
        co.setTelephone("0613903883");
        co.setFonction(f);

        c.setContacts(new ArrayList<Contact>());
        c.getContacts().add(co);
        c.setMateriels(new ArrayList<Materiel>());
        c.getMateriels().add(m);
        c.setVille(v);
        c.setNom("Admin Team");
        c.setAdresse1("2 rue Lucien Faure");
        c.setAdresse2("Salle 001");

        this.clients.add(c);
    }


}
