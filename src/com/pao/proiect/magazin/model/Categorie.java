package com.pao.proiect.magazin.model;

public class Categorie {
    
    private int id;
    private String nume;
    
    public Categorie(int id, String nume) {
        this.id = id;
        this.nume = nume;
    }
    
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public String getNume() {
        return nume;
    }
    
    public void setNume(String nume) {
        this.nume = nume;
    }
    
    @Override
    public String toString() {
        return "Categorie{" +
                "id=" + id +
                ", nume='" + nume + '\'' +
                '}';
    }
}
