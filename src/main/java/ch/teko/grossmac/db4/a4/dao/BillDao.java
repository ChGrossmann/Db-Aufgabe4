package ch.teko.grossmac.db4.a4.dao;

import ch.teko.grossmac.db4.a4.beans.Bill;
import com.mongodb.client.result.DeleteResult;
import java.util.ArrayList;

import java.util.GregorianCalendar;
import java.util.List;
import org.bson.Document;

/**
 * In der BillDao Klasse werden alle operationen mit der Datenbank gemacht.
 * 
 * createBill
 * updateBill
 * searchBill
 * searchBillNr
 * deleteBillNr
 * 
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
            
           
        /**
         * Hier wird die Verbindung zur Colletion bill erstellt.
         */
        conn.connection("bill");
        
        /**
         * Hier werden alle Parameter zu einem Document zusammengeführt.
         */
        Document bill = new Document();
        bill.append("rechnungsnummer", rechnungsnummer);
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
        
        /**
         * Hier wird das vorbereitete Document in die Datenbank gespeichert.
        */
        conn.mdbCollection.insertOne(bill);
        
        return bill;

        
    }
        
        /**
         * Mit updateBill werden alle Daten erstellt um eine Rechnung zu ändern.
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
        public Document updateBill(
                int rechnungsnummerAlt,
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
            
           
        /**
         * Hier wird die Verbindung zur Colletion bill erstellt.
         */
        conn.connection("bill");
        
        /**
         * Die Erstellung des filters für die Suche nach dem richtigen Eintrag.
         */
        Document filter = new Document();
        filter.append("rechnungsnummer", rechnungsnummerAlt);

        /**
         * Hier werden alle Parameter zu einem Document zusammengeführt.
         */
        Document billNew = new Document();
        billNew.append("rechnungsnummer", rechnungsnummer);
        billNew.append("datum", new GregorianCalendar().getTime());
        billNew.append("mandant", erstelleMandant(rechnung_firma, 
                 rechnung_name, 
                 rechnung_strasse, 
                 rechnung_plz, 
                 rechnung_ort));
        billNew.append("kunde", erstelleKunde( kunde_firma,
                 kunde_name, 
                 kunde_strasse, 
                 kunde_plz, 
                kunde_ort));
        billNew.append("lieferadresse", erstelleLieferadresse( liefer_firma, 
                 liefer_name, 
                 liefer_strasse, 
                 liefer_plz, 
                 liefer_ort));
        billNew.append("positionen", erstellePositionen( new_1_artikelnummer, 
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
        

        billNew.append("bemerkung", bemerkung);
        
        billNew.append("mwstsatz", billObject.getMwst());
        billNew.append("zahlungsbedingung", billObject.getZahlungsbedingung());
        billNew.append("danke", billObject.getDanke());
        
        /**
         * 1. Parameter ist der filter und der 2. das einzusetzende dokument
         */
        conn.mdbCollection.findOneAndReplace(filter, billNew);
        
        return billNew;

        
    }

    /**
     * Hier wird ein Mandant erstellt für die Rechnung.
     * @param rechnung_firma
     * @param rechnung_name
     * @param rechnung_strasse
     * @param rechnung_plz
     * @param rechnung_ort
     * @return 
     */   
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

    /**
     * Hier wird der Kunde erstellt für die Rechnung.
     * @param kunde_firma
     * @param kunde_name
     * @param kunde_strasse
     * @param kunde_plz
     * @param kunde_ort
     * @return 
     */
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

    /**
     * Hier wird die Lieferadresse für die Rechnung erstellt
     * @param liefer_firma
     * @param liefer_name
     * @param liefer_strasse
     * @param liefer_plz
     * @param liefer_ort
     * @return 
     */
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

    /**
     * Hier wird ein Artikel erstellt für die Rechnung
     * @param artikelNr
     * @param beschreibung
     * @param farbe
     * @param menge
     * @param einheit
     * @param einzelpreis
     * @return 
     */
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

    /**
     * Hier werden alle 5 Positionen erstellt für die Rechnung.
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
     * @return 
     */
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

        /**
         * Die Positionen werden in eine ArrayList abgefüllt.
         */
        ArrayList<Document> positionen = new ArrayList<>();
        positionen.add(erstelleArtikel(new_1_artikelnummer, new_1_bezeichnung, new_1_farbe, new_1_anzahl, new_1_einheit, new_1_preis));
        positionen.add(erstelleArtikel(new_2_artikelnummer, new_2_bezeichnung, new_2_farbe, new_2_anzahl, new_2_einheit, new_2_preis));
        positionen.add(erstelleArtikel(new_3_artikelnummer, new_3_bezeichnung, new_3_farbe, new_3_anzahl, new_3_einheit, new_3_preis));
        positionen.add(erstelleArtikel(new_4_artikelnummer, new_4_bezeichnung, new_4_farbe, new_4_anzahl, new_4_einheit, new_4_preis));
        positionen.add(erstelleArtikel(new_5_artikelnummer, new_5_bezeichnung, new_5_farbe, new_5_anzahl, new_5_einheit, new_5_preis));
        

        return positionen;
    }
    
   /**
    * Die Methode um alle(20) Rechnungen aud der Datenbank zu lesen und in eine ArrayList zu schreiben.
    * @return 
    */
   public List<Document> searchBill(){
       
       conn.connection("bill");
       
       
       List<Document> listBill = conn.mdbCollection.find().into(new ArrayList<Document>());
       
       
       return listBill;
   }
   
   /**
    * Die Methode um nach einer Rechnungsnummer zu suchen.
    * @param billNr
    * @return 
    */
   public List<Document> searchBillNr(int billNr){
       
       conn.connection("bill");
       
       Document filter = new Document("rechnungsnummer", billNr);
       
       List<Document> bill = conn.mdbCollection.find(filter).into(new ArrayList<Document>());
       
       
       return bill;
   }
   
   /**
    * Die Methode um einen Eintrag zu löschen.
    * @param billNr
    * @return 
    */
   public Document deleteBillNr(int billNr){
       
       conn.connection("bill");
       
       Document filter = new Document("rechnungsnummer", billNr);
       
      DeleteResult bill = conn.mdbCollection.deleteOne(filter);
       
      Document delCount = new Document ("delCount", bill.getDeletedCount());
       
       return delCount;
   }
    
    
}
