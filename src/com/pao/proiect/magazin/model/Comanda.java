package com.pao.proiect.magazin.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Comanda {
    
    private static int numarComenziGlobal = 1;
    
    private int id;
    private Client client;
    private List<LinieComanda> linii;
    private LocalDateTime dataPlasare;
    private String status; // PLASATA, CONFIRMATA, EXPEDITA, LIVRATA
    
    public Comanda(Client client) {
        this.id = numarComenziGlobal++;
        this.client = client;
        this.linii = new ArrayList<>();
        this.dataPlasare = LocalDateTime.now();
        this.status = "PLASATA";
    }
    
    public int getId() {
        return id;
    }
    
    public Client getClient() {
        return client;
    }
    
    public void setClient(Client client) {
        this.client = client;
    }
    
    public List<LinieComanda> getLinii() {
        return linii;
    }
    
    public void adaugaLinie(LinieComanda linie) {
        this.linii.add(linie);
    }
    
    public LocalDateTime getDataPlasare() {
        return dataPlasare;
    }
    
    public String getStatus() {
        return status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }
    
    public double getTotalComanda() {
        double total = 0;
        for (LinieComanda linie : linii) {
            total += linie.getSubtotal();
        }
        return total;
    }
    
    @Override
    public String toString() {
        return "Comanda{" +
                "id=" + id +
                ", client=" + client.getNume() + " " + client.getPrenume() +
                ", dataPlasare=" + dataPlasare +
                ", status='" + status + '\'' +
                ", totalComanda=" + getTotalComanda() +
                ", linii=" + linii.size() +
                '}';
    }
}
