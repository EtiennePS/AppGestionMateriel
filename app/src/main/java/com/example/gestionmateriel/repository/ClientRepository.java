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
        json = new String(json.getBytes("ISO-8859-1"), "UTF-8");
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
        Ville v = new Ville();
        v.setCodePostale("33000");
        v.setNom("Bordeaux");

        Fonction f = new Fonction();
        f.setLibelle("Xtrem Programmeur");
        Contact co = new Contact();
        co.setNom("LAURIN");
        co.setPrenom("Maxime");
        co.setEmail("17.laurinmaxime@gmail.com");
        co.setTelephone("0613903883");
        co.setFonction(f);

        Fonction f2 = new Fonction();
        f2.setLibelle("Support");
        Contact co2 = new Contact();
        co2.setNom("PICHERIT");
        co2.setPrenom("Étienne");
        co2.setEmail("etienne.picherit@gmail.com");
        co2.setTelephone("0661738790");
        co2.setFonction(f2);

        Fonction f3 = new Fonction();
        f3.setLibelle("Designer Expert");
        Contact co3 = new Contact();
        co3.setNom("BOUCHET");
        co3.setPrenom("Kateryna");
        co3.setEmail("kateryna.bouchet@gmail.com");
        co3.setTelephone("018569857");
        co3.setFonction(f3);

        Fonction f4 = new Fonction();
        f3.setLibelle("Technicien");
        Contact co4 = new Contact();
        co4.setNom("Pablo");
        co4.setPrenom("Pablito");
        co4.setEmail("Pablo.pablito@gmail.com");
        co4.setTelephone("0612345678");
        co4.setFonction(f3);

        c.setContacts(new ArrayList<Contact>());
        c.getContacts().add(co);
        c.getContacts().add(co2);
        c.getContacts().add(co3);
        c.getContacts().add(co4);

        c.setMateriels(new ArrayList<Materiel>());
        c.getMateriels().add(m);
        c.setVille(v);
        c.setNom("Admin Team");
        c.setAdresse1("2 rue Lucien Faure");
        c.setAdresse2("Salle 001");

        this.clients.add(c);
    }


}
