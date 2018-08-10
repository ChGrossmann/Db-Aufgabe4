/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.teko.grossmac.db4.a4;

import ch.teko.grossmac.db4.a4.beans.Bill;
import ch.teko.grossmac.db4.a4.beans.Product;
import ch.teko.grossmac.db4.a4.dao.BillDao;
import ch.teko.grossmac.db4.a4.dao.DBConnection;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.bson.Document;

/**
 *
 * @author ch.grossmann
 */
@WebServlet(name = "SearchBill", urlPatterns = {"/SearchBill"})
public class SearchBill extends HttpServlet {
    

    
     @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
     
        

        
        // DAO Layer aufrufen
        BillDao dao = new BillDao();
        List<Document> bills = dao.searchBill();
        
        
        ArrayList<Bill> listBill = new ArrayList<>();
        
        for(Document d : bills){
            
            
        //Bean Bill abfüllen
        Bill bill = new Bill();

        bill.setNumber(d.getInteger("rechnungsnummer"));

        bill.setDate(d.getDate("datum"));

        Document mandant = (Document) d.get("mandant");
        bill.setMandant(mandant);

        Document kunde = (Document) d.get("kunde");
        bill.setCustomer(kunde);

        Document lieferadresse = (Document) d.get("lieferadresse");
        bill.setAddress(lieferadresse);

        ArrayList<Document> positionen = (ArrayList<Document>) d.get("positionen");

        Document price0 = positionen.get(0);
        double total0 = price0.getInteger("menge") * price0.getDouble("einzelpreis");
        Document price1 = positionen.get(1);
        double total1 = price1.getInteger("menge") * price1.getDouble("einzelpreis");
        Document price2 = positionen.get(2);
        double total2 = price2.getInteger("menge") * price2.getDouble("einzelpreis");
        Document price3 = positionen.get(3);
        double total3 = price3.getInteger("menge") * price3.getDouble("einzelpreis");
        Document price4 = positionen.get(4);
        double total4 = price4.getInteger("menge") * price4.getDouble("einzelpreis");
        double priceTotal = total0 + total1 + total2 + total3 + total4;
        bill.setPriceTotal(priceTotal);

        bill.setComment(d.get("bemerkung").toString());

        bill.setMwst(d.getDouble("mwstsatz"));
        bill.setZahlungsbedingung(d.get("zahlungsbedingung").toString());
        bill.setDanke(d.get("danke").toString());

        Product position0 = new Product();
        Document docPosition0 = price0;
        position0.setArtikelNr(docPosition0.getInteger("artikelNr"));
        position0.setBezeichung(docPosition0.get("bezeichnung").toString());
        position0.setFarbe(docPosition0.get("farbe").toString());
        position0.setAnzahl(docPosition0.getInteger("menge"));
        position0.setEinheit(docPosition0.get("einheit").toString());
        position0.setPreis(docPosition0.getDouble("einzelpreis"));

        Product position1 = new Product();
        Document docPosition1 = price1;
        position1.setArtikelNr(docPosition1.getInteger("artikelNr"));
        position1.setBezeichung(docPosition1.get("bezeichnung").toString());
        position1.setFarbe(docPosition1.get("farbe").toString());
        position1.setAnzahl(docPosition1.getInteger("menge"));
        position1.setEinheit(docPosition1.get("einheit").toString());
        position1.setPreis(docPosition1.getDouble("einzelpreis"));

        Product position2 = new Product();
        Document docPosition2 = price2;
        position2.setArtikelNr(docPosition2.getInteger("artikelNr"));
        position2.setBezeichung(docPosition2.get("bezeichnung").toString());
        position2.setFarbe(docPosition2.get("farbe").toString());
        position2.setAnzahl(docPosition2.getInteger("menge"));
        position2.setEinheit(docPosition2.get("einheit").toString());
        position2.setPreis(docPosition2.getDouble("einzelpreis"));

        Product position3 = new Product();
        Document docPosition3 = price3;
        position3.setArtikelNr(docPosition3.getInteger("artikelNr"));
        position3.setBezeichung(docPosition3.get("bezeichnung").toString());
        position3.setFarbe(docPosition3.get("farbe").toString());
        position3.setAnzahl(docPosition3.getInteger("menge"));
        position3.setEinheit(docPosition3.get("einheit").toString());
        position3.setPreis(docPosition3.getDouble("einzelpreis"));

        Product position4 = new Product();
        Document docPosition4 = price4;
        position4.setArtikelNr(docPosition4.getInteger("artikelNr"));
        position4.setBezeichung(docPosition4.get("bezeichnung").toString());
        position4.setFarbe(docPosition4.get("farbe").toString());
        position4.setAnzahl(docPosition4.getInteger("menge"));
        position4.setEinheit(docPosition4.get("einheit").toString());
        position4.setPreis(docPosition4.getDouble("einzelpreis"));

        ArrayList<Product> products = new ArrayList<>();
        products.add(position0);
        products.add(position1);
        products.add(position2);
        products.add(position3);
        products.add(position4);

        bill.setPositionen(products);
        
        listBill.add(bill);
        };
        
        
        
        
        req.setAttribute("ListBill", listBill);
        req.getRequestDispatcher("listBill.jsp").forward(req, resp);
        
        
       
       
        

}
}