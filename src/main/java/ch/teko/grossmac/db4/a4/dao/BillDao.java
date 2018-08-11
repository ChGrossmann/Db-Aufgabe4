package ch.teko.grossmac.db4.a4.dao;

import ch.teko.grossmac.db4.a4.beans.Bill;
import java.util.ArrayList;

import java.util.GregorianCalendar;
import java.util.List;
import org.bson.Document;

/**
 * In der BillDao Klasse werden die Daten die von NewBill übergeben werden in die Datenbank eingespiesen.
 * @author ch.grossmann
 */
public class BillDao {
    Bill billObject = new Bill();           
                        

    DBConnection conn = new DBConnection();
    
    
        /**
         * Mit createBill werden alle Daten erstellt um eine Rechnung zu erstellen.
         * @param rechnungsnummer
         * @param rechnung_firma
         * @param rechnung_name
         * @param rechnung_strasse
         * @param rechnung_plz
         * @param rechnung_ort
         * @param kunde_firma
         * @param kunde_name
         * @param kunde_strasse
         * @param kunde_plz
         * @param kunde_ort
         * @param liefer_firma
         * @param liefer_name
         * @param liefer_strasse
         * @param liefer_plz
         * @param liefer_ort
         * @param new_1_artikelnummer
         * @param new_1_bezeichnung
         * @param new_1_farbe
         * @param new_1_anzahl
         * @param new_1_einheit
         * @param new_1_preis
         * @param new_2_artikelnummer
         * @param new_2_bezeichnung
         * @param new_2_farbe
         * @param new_2_anzahl
         * @param new_2_einheit
         * @param new_2_preis
         * @param new_3_artikelnummer
         * @param new_3_bezeichnung
         * @param new_3_farbe
         * @param new_3_anzahl
         * @param new_3_einheit
         * @param new_3_preis
         * @param new_4_artikelnummer
         * @param new_4_bezeichnung
         * @param new_4_farbe
         * @param new_4_anzahl
         * @param new_4_einheit
         * @param new_4_preis
         * @param new_5_artikelnummer
         * @param new_5_bezeichnung
         * @param new_5_farbe
         * @param new_5_anzahl
         * @param new_5_einheit
         * @param new_5_preis
         * @param bemerkung
         * @return 
         */
        public Document createBill(
                int rechnungsnummer,
                
                String rechnung_firma, 
                String rechnung_name, 
                String rechnung_strasse, 
                int rechnung_plz, 
                String rechnung_ort, 
                
                String kunde_firma,
                String kunde_name, 
                String kunde_strasse, 
                int kunde_plz, 
                String kunde_ort, 
                
                String liefer_firma, 
                String liefer_name, 
                String liefer_strasse, 
                int liefer_plz, 
                String liefer_ort, 
                
                int new_1_artikelnummer, 
                String new_1_bezeichnung, 
                String new_1_farbe, 
                int new_1_anzahl, 
                String new_1_einheit, 
                double new_1_preis, 
                
                int new_2_artikelnummer, 
                String new_2_bezeichnung, 
                String new_2_farbe,
                int new_2_anzahl, 
                String new_2_einheit, 
                double new_2_preis, 
                
                int new_3_artikelnummer, 
                String new_3_bezeichnung, 
                String new_3_farbe, 
                int new_3_anzahl, 
                String new_3_einheit, 
                double new_3_preis,
                
                int new_4_artikelnummer, 
                String new_4_bezeichnung, 
                String new_4_farbe, 
                int new_4_anzahl, 
                String new_4_einheit, 
                double new_4_preis, 
                
                int new_5_artikelnummer, 
                String new_5_bezeichnung,
                String new_5_farbe, 
                int new_5_anzahl, 
                String new_5_einheit, 
                double new_5_preis, 
                
                String bemerkung){
            
           

        conn.connection("bill");
        

        Document bill = new Document();
        bill.append("rechnungsnummer",rechnungsnummer);
        bill.append("datum", new GregorianCalendar().getTime());
        bill.append("mandant", erstelleMandant(rechnung_firma, 
                 rechnung_name, 
                 rechnung_strasse, 
                 rechnung_plz, 
                 rechnung_ort));
        bill.append("kunde", erstelleKunde( kunde_firma,
                 kunde_name, 
                 kunde_strasse, 
                 kunde_plz, 
                kunde_ort));
        bill.append("lieferadresse", erstelleLieferadresse( liefer_firma, 
                 liefer_name, 
                 liefer_strasse, 
                 liefer_plz, 
                 liefer_ort));
        bill.append("positionen", erstellePositionen( new_1_artikelnummer, 
                 new_1_bezeichnung, 
                 new_1_farbe, 
                 new_1_anzahl, 
                 new_1_einheit, 
                 new_1_preis, 
                
                 new_2_artikelnummer, 
                 new_2_bezeichnung, 
                 new_2_farbe,
                 new_2_anzahl, 
                 new_2_einheit, 
                 new_2_preis, 
                
                 new_3_artikelnummer, 
                 new_3_bezeichnung, 
                 new_3_farbe, 
                 new_3_anzahl, 
                 new_3_einheit, 
                 new_3_preis,
                
                 new_4_artikelnummer, 
                 new_4_bezeichnung, 
                 new_4_farbe, 
                 new_4_anzahl, 
                 new_4_einheit, 
                 new_4_preis, 
                
                 new_5_artikelnummer, 
                 new_5_bezeichnung,
                 new_5_farbe, 
                 new_5_anzahl, 
                 new_5_einheit, 
                 new_5_preis));
        

        bill.append("bemerkung", bemerkung);
        
        bill.append("mwstsatz", billObject.getMwst());
        bill.append("zahlungsbedingung", billObject.getZahlungsbedingung());
        bill.append("danke", billObject.getDanke());
        
        conn.mdbCollection.insertOne(bill);
        
        return bill;

        
    }

        
    private Document erstelleMandant(String rechnung_firma, 
                String rechnung_name, 
                String rechnung_strasse, 
                int rechnung_plz, 
                String rechnung_ort) {
        Document doc = new Document();
        doc.append("firmenname", rechnung_firma)
                .append("name", rechnung_name)
                .append("strasse", rechnung_strasse)
                .append("postleitzahl", rechnung_plz)
                .append("ort", rechnung_ort);

        return doc;
    }

    private Document erstelleKunde(String kunde_firma,
                String kunde_name, 
                String kunde_strasse, 
                int kunde_plz, 
                String kunde_ort) {
        Document doc = new Document();
        doc.append("firmenname", kunde_firma)
                .append("name", kunde_name)
                .append("strasse", kunde_strasse)
                .append("postleitzahl", kunde_plz)
                .append("ort", kunde_ort);

        return doc;
    }

    private Document erstelleLieferadresse(String liefer_firma, 
                String liefer_name, 
                String liefer_strasse, 
                int liefer_plz, 
                String liefer_ort) {
        Document doc = new Document();
        doc.append("firmenname", liefer_firma)
                .append("name", liefer_name)
                .append("strasse", liefer_strasse)
                .append("postleitzahl", liefer_plz)
                .append("ort", liefer_ort);
        return doc;
    }

    private Document erstelleArtikel(int artikelNr, String beschreibung, 
            String farbe, int menge, String einheit, double einzelpreis) {

        Document doc = new Document();
        doc.append("artikelNr", artikelNr)
                .append("bezeichnung", beschreibung)
                .append("farbe", beschreibung)
                .append("menge", menge)
                .append("einheit", einheit)
                .append("einzelpreis", einzelpreis);

        return doc;

    }

    private ArrayList<Document> erstellePositionen(int new_1_artikelnummer, 
                String new_1_bezeichnung, 
                String new_1_farbe, 
                int new_1_anzahl, 
                String new_1_einheit, 
                double new_1_preis, 
                
                int new_2_artikelnummer, 
                String new_2_bezeichnung, 
                String new_2_farbe,
                int new_2_anzahl, 
                String new_2_einheit, 
                double new_2_preis, 
                
                int new_3_artikelnummer, 
                String new_3_bezeichnung, 
                String new_3_farbe, 
                int new_3_anzahl, 
                String new_3_einheit, 
                double new_3_preis,
                
                int new_4_artikelnummer, 
                String new_4_bezeichnung, 
                String new_4_farbe, 
                int new_4_anzahl, 
                String new_4_einheit, 
                double new_4_preis, 
                
                int new_5_artikelnummer, 
                String new_5_bezeichnung,
                String new_5_farbe, 
                int new_5_anzahl, 
                String new_5_einheit, 
                double new_5_preis) {

        ArrayList<Document> positionen = new ArrayList<>();
        positionen.add(erstelleArtikel(new_1_artikelnummer, new_1_bezeichnung, new_1_farbe, new_1_anzahl, new_1_einheit, new_1_preis));
        positionen.add(erstelleArtikel(new_2_artikelnummer, new_2_bezeichnung, new_2_farbe, new_2_anzahl, new_2_einheit, new_2_preis));
        positionen.add(erstelleArtikel(new_3_artikelnummer, new_3_bezeichnung, new_3_farbe, new_3_anzahl, new_3_einheit, new_3_preis));
        positionen.add(erstelleArtikel(new_4_artikelnummer, new_4_bezeichnung, new_4_farbe, new_4_anzahl, new_4_einheit, new_4_preis));
        positionen.add(erstelleArtikel(new_5_artikelnummer, new_5_bezeichnung, new_5_farbe, new_5_anzahl, new_5_einheit, new_5_preis));
        

        return positionen;
    }
    
    
   public List<Document> searchBill(){
       
       conn.connection("bill");
       
       
       List<Document> listBill = conn.mdbCollection.find().into(new ArrayList<Document>());
       
       
       return listBill;
   }
   
   public Document searchBillNr(int billNr){
       
       conn.connection("bill");
       
       Document filter = new Document("rechnungsnummer", billNr);
       
       Document bill = (Document) conn.mdbCollection.find(filter);
       
       
       return bill;
   }
    
    
    
    
    
    
    //------------------------------------------------------------------------
    


/*

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
            String newPositionen5, 
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
        List<Document> searchBillNr = conn.mdbCollection.find().into(new ArrayList<Document>());

        for (Document d : searchBillNr) {
            System.out.println(d.toJson());
        }
        
        return searchBillNr;
    }
    
*/
    
}
