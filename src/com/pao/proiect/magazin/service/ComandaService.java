package com.pao.proiect.magazin.service;

import com.pao.proiect.magazin.model.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Serviciul pentru gestionarea comenzilor (Singleton)
 */
public class ComandaService {
    
    private static ComandaService instanta = null;
    
    private List<Comanda> comenzi;
    
    private ComandaService() {
        this.comenzi = new ArrayList<>();
    }
    
    public static synchronized ComandaService getInstance() {
        if (instanta == null) {
            instanta = new ComandaService();
        }
        return instanta;
    }
    
    /**
     * Plasează o nouă comandă
     */
    public void plaseazaComanda(Client client, List<LinieComanda> linii) {
        if (client == null) {
            throw new NullPointerException("Clientul nu poate fi null!");
        }
        if (linii == null || linii.isEmpty()) {
            throw new IllegalArgumentException("Comanda trebuie să conțină cel puțin o linie!");
        }
        
        Comanda comanda = new Comanda(client);
        for (LinieComanda linie : linii) {
            comanda.adaugaLinie(linie);
        }
        comenzi.add(comanda);
        
        // Incrementeaza numarul de comenzi ale clientului
        client.setNrComenzi(client.getNrComenzi() + 1);
        
        System.out.println("[COMANDA PLASATA] ID: " + comanda.getId() + 
                ", Total: " + comanda.getTotalComanda() + " lei");
    }
    
    /**
     * Listează toate comenzile din sistem
     */
    public List<Comanda> listeazaComenzi() {
        return new ArrayList<>(comenzi);
    }
    
    /**
     * Afișează comenzile unui client
     */
    public List<Comanda> afiseazaComenziClient(Client client) {
        if (client == null) {
            throw new NullPointerException("Clientul nu poate fi null!");
        }
        return comenzi.stream()
                .filter(c -> c.getClient().getId() == client.getId())
                .collect(Collectors.toList());
    }
    
    /**
     * Obține o comandă după ID
     */
    public Comanda obtineComanda(int id) {
        return comenzi.stream()
                .filter(c -> c.getId() == id)
                .findFirst()
                .orElse(null);
    }
}
