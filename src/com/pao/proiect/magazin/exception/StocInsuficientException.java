package com.pao.proiect.magazin.exception;

public class StocInsuficientException extends Exception {
    
    public StocInsuficientException(String mesaj) {
        super(mesaj);
    }
    
    public StocInsuficientException(String mesaj, Throwable cause) {
        super(mesaj, cause);
    }
}
