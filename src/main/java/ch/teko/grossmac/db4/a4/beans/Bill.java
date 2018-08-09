package ch.teko.grossmac.db4.a4.beans;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import org.bson.Document;

public class Bill {

       
    private int number;
    private Date date;
    private Document mandant;
    private Document customer;
    private Document address;
    private double priceTotal;
    private String comment;
    private double mwst = 7.7;
    private String zahlungsbedingung = "Zahlbar innert 30 Tagen.";
    private String danke = "Vielen Dank für die Bestellung";

    private List<Product> positionen;

    public Bill() {
    }

    public Bill(int number, Date date, Document mandant, Document customer, Document address, double priceTotal, String comment, double mwst, String zahlungsbedingung, String danke, List<Product> positionen) {
        this.number = number;
        this.date = date;
        this.mandant = mandant;
        this.customer = customer;
        this.address = address;
        this.priceTotal = priceTotal;
        this.comment = comment;
        this.mwst = mwst;
        this.zahlungsbedingung = zahlungsbedingung;
        this.danke = danke;
        this.positionen = positionen;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Document getMandant() {
        return mandant;
    }

    public void setMandant(Document mandant) {
        this.mandant = mandant;
    }

    public Document getCustomer() {
        return customer;
    }

    public void setCustomer(Document customer) {
        this.customer = customer;
    }

    public Document getAddress() {
        return address;
    }

    public void setAddress(Document address) {
        this.address = address;
    }

    public double getPriceTotal() {
        return priceTotal;
    }

    public void setPriceTotal(double priceTotal) {
        this.priceTotal = priceTotal;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public double getMwst() {
        return mwst;
    }

    public void setMwst(double mwst) {
        this.mwst = mwst;
    }

    public String getZahlungsbedingung() {
        return zahlungsbedingung;
    }

    public void setZahlungsbedingung(String zahlungsbedingung) {
        this.zahlungsbedingung = zahlungsbedingung;
    }

    public String getDanke() {
        return danke;
    }

    public void setDanke(String danke) {
        this.danke = danke;
    }

    public List<Product> getPositionen() {
        return positionen;
    }

    public void setPositionen(List<Product> positionen) {
        this.positionen = positionen;
    }

    
    



}
