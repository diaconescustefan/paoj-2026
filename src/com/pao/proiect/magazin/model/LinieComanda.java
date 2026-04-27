package com.pao.proiect.magazin.model;


public class LinieComanda {
    
    private Produs produs;
    private int cantitate;
    private double pretUnitar;
    
    public LinieComanda(Produs produs, int cantitate) {
        this.produs = produs;
        this.cantitate = cantitate;
        this.pretUnitar = produs.getPret();
    }
    
    public Produs getProdus() {
        return produs;
    }
    
    public void setProdus(Produs produs) {
        this.produs = produs;
    }
    
    public int getCantitate() {
        return cantitate;
    }
    
    public void setCantitate(int cantitate) {
        this.cantitate = cantitate;
    }
    
    public double getPretUnitar() {
        return pretUnitar;
    }
    
    public void setPretUnitar(double pretUnitar) {
        this.pretUnitar = pretUnitar;
    }
    
    public double getSubtotal() {
        return cantitate * pretUnitar;
    }
    
    @Override
    public String toString() {
        return "LinieComanda{" +
                "produs=" + produs.getNume() +
                ", cantitate=" + cantitate +
                ", pretUnitar=" + pretUnitar +
                ", subtotal=" + getSubtotal() +
                '}';
    }
}
