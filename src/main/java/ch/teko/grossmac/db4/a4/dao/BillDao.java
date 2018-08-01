package ch.teko.grossmac.db4.a4.dao;

import java.util.ArrayList;
import java.util.List;

import java.util.GregorianCalendar;
import org.bson.Document;
import org.bson.conversions.Bson;

public class BillDao {

    DBConnection conn = new DBConnection();
    




    public List<Document> newMandatDao(String newFirmenname, String newStrasse, String newPlz, String newOrt, String newTelefon) {

        conn.connection("mandat");


        Document mandat = new Document("firmenname", newFirmenname)
                .append("strasse", newStrasse)
                .append("plz", newPlz)
                .append("ort", newOrt)
                .append("telefon", newTelefon);

        conn.mdbCollection.insertOne(mandat);

        Bson filter = new Document("firmenname", newFirmenname);
        List<Document> newMandat = conn.mdbCollection.find(filter).into(new ArrayList<Document>());

        for (Document d : newMandat) {
            System.out.println(d.toJson());
        }

        return newMandat;
    }

    public List<Document> newProductDao(String newArtikelnummer, String newArtikelname, String newPreis, String newEinheit, String newMenge) {

        conn.connection("product");


        Document mandat = new Document("artikelnummer", newArtikelnummer)
                .append("artikelname", newArtikelname)
                .append("preis", newPreis)
                .append("einheit", newEinheit)
                .append("menge", newMenge);

        conn.mdbCollection.insertOne(mandat);

        Bson filter = new Document("artikelnummer", newArtikelnummer);
        List<Document> newProduct = conn.mdbCollection.find(filter).into(new ArrayList<Document>());

        for (Document d : newProduct) {
            System.out.println(d.toJson());
        }

        return newProduct;
    }

    public List<Document> newAddressDao(String newId, String newVorname, String newNachname, String newStrasse, String newPlz, String newOrt, String newTelefon) {

        conn.connection("address");
//           

        Document mandat = new Document("id", newVorname)
                .append("vorname", newVorname)
                .append("nachname", newNachname)
                .append("strasse", newStrasse)
                .append("plz", newPlz)
                .append("ort", newOrt)
                .append("telefon", newTelefon);

        conn.mdbCollection.insertOne(mandat);

        Bson filter = new Document("telefon", newTelefon);
        List<Document> newAddress = conn.mdbCollection.find(filter).into(new ArrayList<Document>());

        for (Document d : newAddress) {
            System.out.println(d.toJson());
        }

        return newAddress;
    }
    
    public List<Document> newCustomerDao(String newKundennummer, String newFirmenname, String newVorname, String newNachname, String newStrasse, String newPlz, String newOrt, String newTelefon) {

        conn.connection("customer");
//           

        Document mandat = new Document("kundennummer", newKundennummer)
                .append("firmenname", newFirmenname)
                .append("vorname", newVorname)
                .append("nachname", newNachname)
                .append("strasse", newStrasse)
                .append("plz", newPlz)
                .append("ort", newOrt)
                .append("telefon", newTelefon);

        conn.mdbCollection.insertOne(mandat);

        Bson filter = new Document("kundennummer", newKundennummer);
        List<Document> newCustomer = conn.mdbCollection.find(filter).into(new ArrayList<Document>());

        for (Document d : newCustomer) {
            System.out.println(d.toJson());
        }
        

        return newCustomer;
    }
    
    public List<Document> newBillDao(String newRechnungsnummer, String newMandat,
            String newKunde, String newLieferadressen, String newPositionen1, 
            String newPositionen2, String newPositionen3, String newPositionen4, 
            String newPositionen5, String newPositionen6, String newPositionen7, 
            String newPositionen8, String newPositionen9, String newPositionen10, 
            String newBemerkung) {

        conn.connection("bill");
        
        DBConnection connPos = new DBConnection();
        connPos.connection("product");
        DBConnection connMan = new DBConnection();
        connMan.connection("mandat");
        DBConnection connKun = new DBConnection();
        connKun.connection("customer");
        DBConnection connLief = new DBConnection();
        connLief.connection("address");
        
           
        Document position1Filter = new Document("artikelnummer", newPositionen1);
        Document position1 = connPos.mdbCollection.find(position1Filter).first();
        
        Document position2Filter = new Document("artikelnummer", newPositionen2);
        Document position2 = connPos.mdbCollection.find(position2Filter).first();
        
        Document position3Filter = new Document("artikelnummer", newPositionen3);
        Document position3 = connPos.mdbCollection.find(position3Filter).first();
        
        Document position4Filter = new Document("artikelnummer", newPositionen4);
        Document position4 = connPos.mdbCollection.find(position4Filter).first();
        
        Document position5Filter = new Document("artikelnummer", newPositionen5);
        Document position5 = connPos.mdbCollection.find(position5Filter).first();
        
        Document position6Filter = new Document("artikelnummer", newPositionen6);
        Document position6 = connPos.mdbCollection.find(position6Filter).first();
        
        Document position7Filter = new Document("artikelnummer", newPositionen7);
        Document position7 = connPos.mdbCollection.find(position7Filter).first();
        
        Document position8Filter = new Document("artikelnummer", newPositionen8);
        Document position8 = connPos.mdbCollection.find(position8Filter).first();
        
        Document position9Filter = new Document("artikelnummer", newPositionen9);
        Document position9 = connPos.mdbCollection.find(position9Filter).first();
        
        Document position10Filter = new Document("artikelnummer", newPositionen10);
        Document position10 = connPos.mdbCollection.find(position10Filter).first();
        
        Document mandatFilter = new Document("firmenname", newMandat);
        Document mandat = connMan.mdbCollection.find(mandatFilter).first();
        
        Document kundeFilter = new Document("kundennummer", newKunde);
        Document kunde = connKun.mdbCollection.find(kundeFilter).first();
        
        Document lieferadresseFilter = new Document("id", newLieferadressen);
        Document lieferadresse = connLief.mdbCollection.find(lieferadresseFilter).first();
        
        

        Document bill = new Document("rechnungsnummer", newRechnungsnummer)
                .append("datum", new GregorianCalendar().getTime())
                .append("mandat", mandat)
                .append("kunde", kunde)
                .append("lieferadresse", lieferadresse)
                .append("positionen1", position1)
                .append("positionen2", position2)
                .append("positionen3", position3)
                .append("positionen4", position4)
                .append("positionen5", position5)
                .append("positionen6", position6)
                .append("positionen7", position7)
                .append("positionen8", position8)
                .append("positionen9", position9)
                .append("positionen10", position10)
                .append("bemerkung", newBemerkung)
                .append("mwstsatz", 0.8)
                .append("zahlungsbedingen", "Zahlbar in 30 Tagen, nach erhalt der Rechnung.")
                .append("danke", "Vielen Dank für Ihre Bestellung.");

        conn.mdbCollection.insertOne(bill);

        Bson filter = new Document("rechnungsnummer", newRechnungsnummer);
        List<Document> newBill = conn.mdbCollection.find(filter).into(new ArrayList<Document>());

        for (Document d : newBill) {
            System.out.println(d.toJson());
        }
        

        return newBill;
    }
    
    public List<Document> searchBillDao() {
        
        conn.connection("bill");
        
        
        List<Document> searchBillNr = conn.mdbCollection.find().into(new ArrayList<Document>());

        for (Document d : searchBillNr) {
            System.out.println(d.toJson());
        }
        
        return searchBillNr;
    }
    
    
    public List<Document> searchBillNrDao(String searchRechnungsnummer) {
        
        conn.connection("bill");
        
        Bson filter = new Document("rechnungsnummer", searchRechnungsnummer);
        List<Document> searchBillNr = conn.mdbCollection.find(filter).into(new ArrayList<Document>());

        for (Document d : searchBillNr) {
            System.out.println(d.toJson());
        }
        
        return searchBillNr;
    }
    

    
}
