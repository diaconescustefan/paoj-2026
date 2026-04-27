package com.pao.proiect.magazin.model;

import java.util.Objects;


public class Produs {
    
    private CodProdus cod;
    private String nume;
    private String descriere;
    private double pret;
    private int stoc;
    private Categorie categorie;
    private Furnizor furnizor;
    
    public Produs(CodProdus cod, String nume, String descriere, double pret,
                  int stoc, Categorie categorie, Furnizor furnizor) {
        this.cod = cod;
        this.nume = nume;
        this.descriere = descriere;
        this.pret = pret;
        this.stoc = stoc;
        this.categorie = categorie;
        this.furnizor = furnizor;
    }
    
    public CodProdus getCod() {
        return cod;
    }
    
    public void setCod(CodProdus cod) {
        this.cod = cod;
    }
    
    public String getNume() {
        return nume;
    }
    
    public void setNume(String nume) {
        this.nume = nume;
    }
    
    public String getDescriere() {
        return descriere;
    }
    
    public void setDescriere(String descriere) {
        this.descriere = descriere;
    }
    
    public double getPret() {
        return pret;
    }
    
    public void setPret(double pret) {
        this.pret = pret;
    }
    
    public int getStoc() {
        return stoc;
    }
    
    public void setStoc(int stoc) {
        this.stoc = stoc;
    }
    
    public Categorie getCategorie() {
        return categorie;
    }
    
    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }
    
    public Furnizor getFurnizor() {
        return furnizor;
    }
    
    public void setFurnizor(Furnizor furnizor) {
        this.furnizor = furnizor;
    }
    
    @Override
    public String toString() {
        return "Produs{" +
                "cod=" + cod +
                ", nume='" + nume + '\'' +
                ", descriere='" + descriere + '\'' +
                ", pret=" + pret +
                ", stoc=" + stoc +
                ", categorie=" + categorie +
                ", furnizor=" + furnizor +
                '}';
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Produs produs = (Produs) o;
        return Objects.equals(cod, produs.cod);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(cod);
    }
}
