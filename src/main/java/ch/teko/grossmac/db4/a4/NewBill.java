/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.teko.grossmac.db4.a4;

import ch.teko.grossmac.db4.a4.dao.BillDao;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.bson.Document;

/**
 *In NewBill werden die Parameter der Website abgefangen und weiter geschickt via dao.createBill .
 * @author ch.grossmann
 */
@WebServlet(name = "NewBill", urlPatterns = {"/NewBill"})
public class NewBill extends HttpServlet {

    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        
        // Formdaten übernehmen
        //Rechnungsnummer
        int rechnungsnummer = Integer.parseInt(req.getParameter("rechnungsnummer"));
        
        //Rechnugsadresse
        String rechnung_firma = req.getParameter("rechnung_firma");
        String rechnung_name = req.getParameter("rechnung_name");
        String rechnung_strasse = req.getParameter("rechnung_strasse");
        int rechnung_plz = Integer.parseInt(req.getParameter("rechnung_plz"));
        String rechnung_ort = req.getParameter("rechnung_ort");
        
        //Kunde
        String kunde_firma = req.getParameter("kunde_firma");
        String kunde_name = req.getParameter("kunde_name");
        String kunde_strasse = req.getParameter("kunde_strasse");
        int kunde_plz = Integer.parseInt(req.getParameter("kunde_plz"));
        String kunde_ort = req.getParameter("kunde_ort");
        
        //Lieferadresse
        String liefer_firma = req.getParameter("liefer_firma");
        String liefer_name = req.getParameter("liefer_name");
        String liefer_strasse = req.getParameter("liefer_strasse");
        int liefer_plz = Integer.parseInt(req.getParameter("liefer_plz"));
        String liefer_ort = req.getParameter("liefer_ort");
        
        //Position 1
        int new_1_artikelnummer = Integer.parseInt(req.getParameter("1_artikelnummer"));
        String new_1_bezeichnung = req.getParameter("1_bezeichnung");
        String new_1_farbe = req.getParameter("1_farbe");
        int new_1_anzahl = Integer.parseInt(req.getParameter("1_anzahl"));
        String new_1_einheit = req.getParameter("1_einheit");
        double new_1_preis = Double.parseDouble(req.getParameter("1_preis"));
        
        //Position 2
        int new_2_artikelnummer = Integer.parseInt(req.getParameter("2_artikelnummer"));
        String new_2_bezeichnung = req.getParameter("2_bezeichnung");
        String new_2_farbe = req.getParameter("2_farbe");
        int new_2_anzahl = Integer.parseInt(req.getParameter("2_anzahl"));
        String new_2_einheit = req.getParameter("2_einheit");
        double new_2_preis = Double.parseDouble(req.getParameter("2_preis"));
        
        //Position 3
        int new_3_artikelnummer= Integer.parseInt(req.getParameter("3_artikelnummer"));
        String new_3_bezeichnung = req.getParameter("3_bezeichnung");
        String new_3_farbe= req.getParameter("3_farbe");
        int new_3_anzahl = Integer.parseInt(req.getParameter("3_anzahl"));
        String new_3_einheit = req.getParameter("3_einheit");
        double new_3_preis = Double.parseDouble(req.getParameter("3_preis"));
        
        //Position 4
        int new_4_artikelnummer = Integer.parseInt(req.getParameter("4_artikelnummer"));
        String new_4_bezeichnung = req.getParameter("4_bezeichnung");
        String new_4_farbe = req.getParameter("4_farbe");
        int new_4_anzahl = Integer.parseInt(req.getParameter("4_anzahl"));
        String new_4_einheit = req.getParameter("4_einheit");
        double new_4_preis = Double.parseDouble(req.getParameter("4_preis"));
        
        //Position 5
        int new_5_artikelnummer = Integer.parseInt(req.getParameter("5_artikelnummer"));
        String new_5_bezeichnung = req.getParameter("5_bezeichnung");
        String new_5_farbe = req.getParameter("5_farbe");
        int new_5_anzahl = Integer.parseInt(req.getParameter("5_anzahl"));
        String new_5_einheit = req.getParameter("5_einheit");
        double new_5_preis = Double.parseDouble(req.getParameter("5_preis"));
        
        //Bemerkung
        String bemerkung = req.getParameter("bemerkung");
        
        
        // DAO Layer aufrufen
        BillDao dao = new BillDao();
        Document newBill = dao.createBill(rechnungsnummer, rechnung_firma, rechnung_name, rechnung_strasse, rechnung_plz, rechnung_ort, kunde_firma,
                kunde_name, kunde_strasse, kunde_plz, kunde_ort, liefer_firma, liefer_name, liefer_strasse, liefer_plz, liefer_ort, new_1_artikelnummer, 
                new_1_bezeichnung, new_1_farbe, new_1_anzahl, new_1_einheit, new_1_preis, new_2_artikelnummer, new_2_bezeichnung, new_2_farbe,
                new_2_anzahl, new_2_einheit, new_2_preis, new_3_artikelnummer, new_3_bezeichnung, new_3_farbe, new_3_anzahl, new_3_einheit, new_3_preis,
                new_4_artikelnummer, new_4_bezeichnung, new_4_farbe, new_4_anzahl, new_4_einheit, new_4_preis, new_5_artikelnummer, new_5_bezeichnung,
                new_5_farbe, new_5_anzahl, new_5_einheit, new_5_preis, bemerkung);

        // Daten an JSP Datei übergeben
        req.setAttribute("Bill", newBill);
        req.getRequestDispatcher("index.jsp").forward(req, resp);

}
}
