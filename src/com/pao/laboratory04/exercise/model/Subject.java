package com.pao.laboratory04.exercise.model;

/**
 * Enum Subject - Reprezinta materiile disponibile
 */
public enum Subject {
    PAOJ("Programare Avansata pe Obiecte", 6),
    BD("Baze de Date", 6),
    SO("Sisteme de Operare", 5),
    RC("Retele de Calculatoare", 5),
    IA("Inteligenta Artificiala", 6);
    
    private final String fullName;
    private final int credits;
    
    Subject(String fullName, int credits) {
        this.fullName = fullName;
        this.credits = credits;
    }
    
    public String getFullName() {
        return fullName;
    }
    
    public int getCredits() {
        return credits;
    }
    
    @Override
    public String toString() {
        return name() + " (" + fullName + ", " + credits + " credite)";
    }
}
