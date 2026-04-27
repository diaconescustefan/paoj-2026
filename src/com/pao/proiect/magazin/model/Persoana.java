package com.pao.proiect.magazin.model;

public abstract class Persoana {
    
    protected int id;
    protected String nume;
    protected String prenume;
    protected String email;
    
    public Persoana(int id, String nume, String prenume, String email) {
        this.id = id;
        this.nume = nume;
        this.prenume = prenume;
        this.email = email;
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
    
    public String getPrenume() {
        return prenume;
    }
    
    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    /**
     * Metoda abstractă pe care fiecare tip de persoană trebuie să o implementeze
     */
    public abstract String getRol();
    
    @Override
    public abstract String toString();
}
