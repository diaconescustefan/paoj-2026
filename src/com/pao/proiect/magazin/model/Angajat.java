package com.pao.proiect.magazin.model;

public class Angajat extends Persoana {
    
    protected String departament;
    protected double salariu;
    
    public Angajat(int id, String nume, String prenume, String email, 
                   String departament, double salariu) {
        super(id, nume, prenume, email);
        this.departament = departament;
        this.salariu = salariu;
    }
    
    public String getDepartament() {
        return departament;
    }
    
    public void setDepartament(String departament) {
        this.departament = departament;
    }
    
    public double getSalariu() {
        return salariu;
    }
    
    public void setSalariu(double salariu) {
        this.salariu = salariu;
    }
    
    @Override
    public String getRol() {
        return "Angajat";
    }
    
    @Override
    public String toString() {
        return "Angajat{" +
                "id=" + id +
                ", nume='" + nume + '\'' +
                ", prenume='" + prenume + '\'' +
                ", email='" + email + '\'' +
                ", departament='" + departament + '\'' +
                ", salariu=" + salariu +
                '}';
    }
}
