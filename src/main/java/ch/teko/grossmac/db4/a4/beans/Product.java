/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.teko.grossmac.db4.a4.beans;

/**
 * Die Product Klasse wird als Bean für die Artikel verwendet.
 * @author ch.grossmann
 */
public class Product {
    
    private int artikelNr;
    private String bezeichung;
    private String farbe;
    private int anzahl;
    private String einheit;
    private double preis;

    public Product() {
    }

    public Product(int artikelNr, String bezeichung, String farbe, int anzahl, String einheit, double preis) {
        this.artikelNr = artikelNr;
        this.bezeichung = bezeichung;
        this.farbe = farbe;
        this.anzahl = anzahl;
        this.einheit = einheit;
        this.preis = preis;
    }

    public int getArtikelNr() {
        return artikelNr;
    }

    public void setArtikelNr(int artikelNr) {
        this.artikelNr = artikelNr;
    }

    public String getBezeichung() {
        return bezeichung;
    }

    public void setBezeichung(String bezeichung) {
        this.bezeichung = bezeichung;
    }

    public String getFarbe() {
        return farbe;
    }

    public void setFarbe(String farbe) {
        this.farbe = farbe;
    }

    public int getAnzahl() {
        return anzahl;
    }

    public void setAnzahl(int anzahl) {
        this.anzahl = anzahl;
    }

    public String getEinheit() {
        return einheit;
    }

    public void setEinheit(String einheit) {
        this.einheit = einheit;
    }

    public double getPreis() {
        return preis;
    }

    public void setPreis(double preis) {
        this.preis = preis;
    }
    
    
}
