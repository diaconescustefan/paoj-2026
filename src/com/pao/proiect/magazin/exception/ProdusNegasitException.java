package com.pao.proiect.magazin.exception;

public class ProdusNegasitException extends Exception {
    
    public ProdusNegasitException(String mesaj) {
        super(mesaj);
    }
    
    public ProdusNegasitException(String mesaj, Throwable cause) {
        super(mesaj, cause);
    }
}
