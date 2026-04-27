package com.pao.proiect.magazin.model;

public class Manager extends Angajat {
    
    private int numarSubordonati;
    private double bonusPerformanta;
    
    public Manager(int id, String nume, String prenume, String email,
                   String departament, double salariu, int numarSubordonati, 
                   double bonusPerformanta) {
        super(id, nume, prenume, email, departament, salariu);
        this.numarSubordonati = numarSubordonati;
        this.bonusPerformanta = bonusPerformanta;
    }
    
    public int getNumarSubordonati() {
        return numarSubordonati;
    }
    
    public void setNumarSubordonati(int numarSubordonati) {
        this.numarSubordonati = numarSubordonati;
    }
    
    public double getBonusPerformanta() {
        return bonusPerformanta;
    }
    
    public void setBonusPerformanta(double bonusPerformanta) {
        this.bonusPerformanta = bonusPerformanta;
    }
    
    @Override
    public String getRol() {
        return "Manager";
    }
    
    @Override
    public String toString() {
        return "Manager{" +
                "id=" + id +
                ", nume='" + nume + '\'' +
                ", prenume='" + prenume + '\'' +
                ", email='" + email + '\'' +
                ", departament='" + departament + '\'' +
                ", salariu=" + salariu +
                ", numarSubordonati=" + numarSubordonati +
                ", bonusPerformanta=" + bonusPerformanta +
                '}';
    }
}
