package com.pao.proiect.magazin.service;

import com.pao.proiect.magazin.model.*;
import com.pao.proiect.magazin.exception.ProdusNegasitException;
import com.pao.proiect.magazin.exception.StocInsuficientException;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Serviciul pentru gestionarea produselor (Singleton)
 */
public class ProdusService {
    
    private static ProdusService instanta = null;
    
    private Map<CodProdus, Produs> produse;
    private List<Furnizor> furnizori;
    
    private ProdusService() {
        this.produse = new HashMap<>();
        this.furnizori = new ArrayList<>();
    }
    
    public static synchronized ProdusService getInstance() {
        if (instanta == null) {
            instanta = new ProdusService();
        }
        return instanta;
    }
    
    /**
     * Adaugă un produs în magazin
     */
    public void adaugaProdus(Produs produs) {
        if (produs == null) {
            throw new NullPointerException("Produsul nu poate fi null!");
        }
        if (produs.getCod() == null) {
            throw new NullPointerException("Codul produsului nu poate fi null!");
        }
        produse.put(produs.getCod(), produs);
        System.out.println("[ADAUGAT] Produs: " + produs.getNume());
    }
    
    /**
     * Șterge un produs din magazin după cod
     */
    public void stergeProdus(CodProdus cod) throws ProdusNegasitException {
        if (cod == null) {
            throw new NullPointerException("Codul produsului nu poate fi null!");
        }
        if (!produse.containsKey(cod)) {
            throw new ProdusNegasitException("Produsul cu codul " + cod.getCod() + " nu a fost găsit!");
        }
        Produs produs = produse.remove(cod);
        System.out.println("[STERS] Produs: " + produs.getNume());
    }
    
    /**
     * Caută un produs după cod
     */
    public Produs cautaProdusDupaCod(CodProdus cod) throws ProdusNegasitException {
        if (cod == null) {
            throw new NullPointerException("Codul produsului nu poate fi null!");
        }
        if (!produse.containsKey(cod)) {
            throw new ProdusNegasitException("Produsul cu codul " + cod.getCod() + " nu a fost găsit!");
        }
        return produse.get(cod);
    }
    
    /**
     * Listează toate produsele din magazin
     */
    public List<Produs> listeazaProduse() {
        return new ArrayList<>(produse.values());
    }
    
    /**
     * Caută produse după categoria
     */
    public List<Produs> cautaProduseDupaCategorie(String numeCategorie) {
        if (numeCategorie == null || numeCategorie.trim().isEmpty()) {
            throw new IllegalArgumentException("Categoria nu poate fi goală!");
        }
        return produse.values().stream()
                .filter(p -> p.getCategorie() != null && 
                        p.getCategorie().getNume().equalsIgnoreCase(numeCategorie))
                .collect(Collectors.toList());
    }
    
    /**
     * Actualizează stocul unui produs
     */
    public void actualizeazaStoc(CodProdus cod, int cantitateNoua) 
            throws ProdusNegasitException {
        if (cod == null) {
            throw new NullPointerException("Codul produsului nu poate fi null!");
        }
        Produs produs = cautaProdusDupaCod(cod);
        produs.setStoc(cantitateNoua);
        System.out.println("[STOC ACTUALIZAT] " + produs.getNume() + 
                ": " + cantitateNoua + " buc.");
    }
    
    /**
     * Scade stocul unui produs cu o anumită cantitate
     */
    public void scadeStoc(CodProdus cod, int cantitate) 
            throws ProdusNegasitException, StocInsuficientException {
        if (cod == null) {
            throw new NullPointerException("Codul produsului nu poate fi null!");
        }
        Produs produs = cautaProdusDupaCod(cod);
        if (produs.getStoc() < cantitate) {
            throw new StocInsuficientException("Stoc insuficient pentru " + 
                    produs.getNume() + ". Stoc disponibil: " + produs.getStoc());
        }
        produs.setStoc(produs.getStoc() - cantitate);
    }
    
    /**
     * Afișează produsele sortate după preț (crescător)
     */
    public List<Produs> afiseazaProduseSortateDupaPret() {
        return produse.values().stream()
                .sorted(Comparator.comparingDouble(Produs::getPret))
                .collect(Collectors.toList());
    }
    
    /**
     * Adaugă un furnizor în sistem
     */
    public void adaugaFurnizor(Furnizor furnizor) {
        if (furnizor == null) {
            throw new NullPointerException("Furnizorul nu poate fi null!");
        }
        furnizori.add(furnizor);
        System.out.println("[FURNIZOR ADAUGAT] " + furnizor.getNume());
    }
    
    /**
     * Listează toți furnizorii
     */
    public List<Furnizor> listeazaFurnizori() {
        return new ArrayList<>(furnizori);
    }
}
