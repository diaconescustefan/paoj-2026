package com.pao.proiect.magazin.model;

import java.util.Objects;

public final class CodProdus {
    
    private final String cod;
    
    public CodProdus(String cod) {
        if (cod == null || cod.trim().isEmpty()) {
            throw new IllegalArgumentException("Codul produsului nu poate fi gol!");
        }
        this.cod = cod.trim();
    }
    
    public String getCod() {
        return cod;
    }
    
    @Override
    public String toString() {
        return "CodProdus{" +
                "cod='" + cod + '\'' +
                '}';
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CodProdus that = (CodProdus) o;
        return Objects.equals(cod, that.cod);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(cod);
    }
}
