package ch.teko.grossmac.db4.a4;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import org.bson.Document;

public class CreateBill {
    
    public void createRechnung() {

        MongoClient client = MongoClients.create();
        MongoDatabase db = client.getDatabase("beispiele");
        
        MongoCollection<Document> rechnungen = db.getCollection("rechnungen");

        rechnungen.drop();

        Document rechnung = new Document();
        rechnung.append("nummer", 43244);
        rechnung.append("datum", new GregorianCalendar().getTime());
        rechnung.append("mandant", erstelleMandant());
        rechnung.append("kunde", erstelleKunde());
        rechnung.append("lieferadresse", erstelleLieferadresse());
        rechnung.append("positionen", erstellePositionen());

        rechnung.append("bemerkung", "Lorem ipsum dolor sit amet, consetetur sadipscing "
                + "elitr, sed diam nonumy eirmod tempor invidunt ut labore et "
                + "dolore magna aliquyam erat, sed diam voluptua.");
        
        rechnung.append("mwstsatz", 0.077);
        rechnung.append("zahlungsbedingung", "zahlbar 30 Tage netto");
        rechnung.append("danke", "Vielen Dank für die Bestellung");
        
        rechnungen.insertOne(rechnung);

    }

    private Document erstelleMandant() {
        Document doc = new Document();
        doc.append("name", "The Poer of Seeds")
                .append("strasse", "Ahornweg 21")
                .append("postleitzahl", "5003")
                .append("ort", "Bauma")
                .append("telefon", "041 566 77 88");

        return doc;
    }

    private Document erstelleKunde() {
        Document doc = new Document();
        doc.append("name", "Gärtnerei Lüchinger")
                .append("strasse", "Moosweg 22")
                .append("postleitzahl", "3241")
                .append("ort", "Boppelsen");

        return doc;
    }

    private Document erstelleLieferadresse() {
        Document doc = new Document();
        doc.append("name", "Frau Anna Peters")
                .append("strasse", "Sonnenweg 3")
                .append("postleitzahl", "5431")
                .append("ort", "Musterlingen");
        return doc;
    }

    private Document erstelleArtikel(int artikelNr, String beschreibung,
            String einheit, double einzelpreis, int menge) {

        Document doc = new Document();
        doc.append("artikelNr", artikelNr)
                .append("beschreibung", beschreibung)
                .append("einzelpreis", einzelpreis)
                .append("einheit", einheit)
                .append("menge", menge);

        return doc;

    }

    private ArrayList<Document> erstellePositionen() {

        ArrayList<Document> positionen = new ArrayList<>();
        positionen.add(erstelleArtikel(33701, "Kandelaber-Primel, rot", "STCK", 4.50, 3));
        positionen.add(erstelleArtikel(57026, "Lupine blau", "STCK", 1.50, 1));
        positionen.add(erstelleArtikel(77005, "Sonnenblume, gefüllt", "STCK", 0.90, 7));
        positionen.add(erstelleArtikel(80967, "Bergahorn", "STCK", 7.50, 1));
        positionen.add(erstelleArtikel(33463, "Aurikel", "STCK", 5.60, 5));
        positionen.add(erstelleArtikel(80956, "Skabiose, blau", "STCK", 3.80, 4));
        positionen.add(erstelleArtikel(80956, "Jap. Zwergahorn, rot", "STCK", 9.50, 1));
        positionen.add(erstelleArtikel(80356, "Zirbelkiefer", "STCK", 8.30, 1));
        positionen.add(erstelleArtikel(33206, "Kugelprimel", "STCK", 4.70, 3));
        positionen.add(erstelleArtikel(57056, "Margarite, weiss 60cm", "STCK", 3.60, 2));
        positionen.add(erstelleArtikel(57056, "Margarite, pink 60cm", "STCK", 4.30, 1));

        return positionen;
    }

}
