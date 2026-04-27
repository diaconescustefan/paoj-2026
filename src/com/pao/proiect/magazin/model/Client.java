package com.pao.proiect.magazin.model;

import java.util.Objects;

public class Client extends Persoana {
    
    private String telefon;
    private String adresa;
    private int nrComenzi;
    
    public Client(int id, String nume, String prenume, String email,
                  String telefon, String adresa) {
        super(id, nume, prenume, email);
        this.telefon = telefon;
        this.adresa = adresa;
        this.nrComenzi = 0;
    }
    
    public String getTelefon() {
        return telefon;
    }
    
    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }
    
    public String getAdresa() {
        return adresa;
    }
    
    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }
    
    public int getNrComenzi() {
        return nrComenzi;
    }
    
    public void setNrComenzi(int nrComenzi) {
        this.nrComenzi = nrComenzi;
    }
    
    @Override
    public String getRol() {
        return "Client";
    }
    
    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", nume='" + nume + '\'' +
                ", prenume='" + prenume + '\'' +
                ", email='" + email + '\'' +
                ", telefon='" + telefon + '\'' +
                ", adresa='" + adresa + '\'' +
                ", nrComenzi=" + nrComenzi +
                '}';
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return id == client.id;
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
