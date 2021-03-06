/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.teko.grossmac.db4.a4;

import ch.teko.grossmac.db4.a4.beans.Bill;
import ch.teko.grossmac.db4.a4.dao.BillDao;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.bson.Document;

/**
 * In NewBill werden die Parameter der Website abgefangen und weiter geschickt
 * via dao.createBill.
 * Das Document newbill wir mit Hilfe von documentToBill umgewandelt.
 *
 * @author ch.grossmann
 */
public class NewBill extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Formdaten übernehmen
        //Rechnungsnummer
        int rechnungsnummer = Integer.parseInt(request.getParameter("rechnungsnummer"));

        //Rechnugsadresse
        String rechnung_firma = request.getParameter("rechnung_firma");
        String rechnung_name = request.getParameter("rechnung_name");
        String rechnung_strasse = request.getParameter("rechnung_strasse");
        int rechnung_plz = Integer.parseInt(request.getParameter("rechnung_plz"));
        String rechnung_ort = request.getParameter("rechnung_ort");

        //Kunde
        String kunde_firma = request.getParameter("kunde_firma");
        String kunde_name = request.getParameter("kunde_name");
        String kunde_strasse = request.getParameter("kunde_strasse");
        int kunde_plz = Integer.parseInt(request.getParameter("kunde_plz"));
        String kunde_ort = request.getParameter("kunde_ort");

        //Lieferadresse
        String liefer_firma = request.getParameter("liefer_firma");
        String liefer_name = request.getParameter("liefer_name");
        String liefer_strasse = request.getParameter("liefer_strasse");
        int liefer_plz = Integer.parseInt(request.getParameter("liefer_plz"));
        String liefer_ort = request.getParameter("liefer_ort");

        //Position 1
        int new_1_artikelnummer = Integer.parseInt(request.getParameter("1_artikelnummer"));
        String new_1_bezeichnung = request.getParameter("1_bezeichnung");
        String new_1_farbe = request.getParameter("1_farbe");
        int new_1_anzahl = Integer.parseInt(request.getParameter("1_anzahl"));
        String new_1_einheit = request.getParameter("1_einheit");
        double new_1_preis = Double.parseDouble(request.getParameter("1_preis"));

        //Position 2
        int new_2_artikelnummer = Integer.parseInt(request.getParameter("2_artikelnummer"));
        String new_2_bezeichnung = request.getParameter("2_bezeichnung");
        String new_2_farbe = request.getParameter("2_farbe");
        int new_2_anzahl = Integer.parseInt(request.getParameter("2_anzahl"));
        String new_2_einheit = request.getParameter("2_einheit");
        double new_2_preis = Double.parseDouble(request.getParameter("2_preis"));

        //Position 3
        int new_3_artikelnummer = Integer.parseInt(request.getParameter("3_artikelnummer"));
        String new_3_bezeichnung = request.getParameter("3_bezeichnung");
        String new_3_farbe = request.getParameter("3_farbe");
        int new_3_anzahl = Integer.parseInt(request.getParameter("3_anzahl"));
        String new_3_einheit = request.getParameter("3_einheit");
        double new_3_preis = Double.parseDouble(request.getParameter("3_preis"));

        //Position 4
        int new_4_artikelnummer = Integer.parseInt(request.getParameter("4_artikelnummer"));
        String new_4_bezeichnung = request.getParameter("4_bezeichnung");
        String new_4_farbe = request.getParameter("4_farbe");
        int new_4_anzahl = Integer.parseInt(request.getParameter("4_anzahl"));
        String new_4_einheit = request.getParameter("4_einheit");
        double new_4_preis = Double.parseDouble(request.getParameter("4_preis"));

        //Position 5
        int new_5_artikelnummer = Integer.parseInt(request.getParameter("5_artikelnummer"));
        String new_5_bezeichnung = request.getParameter("5_bezeichnung");
        String new_5_farbe = request.getParameter("5_farbe");
        int new_5_anzahl = Integer.parseInt(request.getParameter("5_anzahl"));
        String new_5_einheit = request.getParameter("5_einheit");
        double new_5_preis = Double.parseDouble(request.getParameter("5_preis"));

        //Bemerkung
        String bemerkung = request.getParameter("bemerkung");

        /**
         * Übergabe an das Dao
         */
        BillDao dao = new BillDao();
        Document newBill = dao.createBill(rechnungsnummer, rechnung_firma, rechnung_name, rechnung_strasse, rechnung_plz, rechnung_ort, kunde_firma,
                kunde_name, kunde_strasse, kunde_plz, kunde_ort, liefer_firma, liefer_name, liefer_strasse, liefer_plz, liefer_ort, new_1_artikelnummer,
                new_1_bezeichnung, new_1_farbe, new_1_anzahl, new_1_einheit, new_1_preis, new_2_artikelnummer, new_2_bezeichnung, new_2_farbe,
                new_2_anzahl, new_2_einheit, new_2_preis, new_3_artikelnummer, new_3_bezeichnung, new_3_farbe, new_3_anzahl, new_3_einheit, new_3_preis,
                new_4_artikelnummer, new_4_bezeichnung, new_4_farbe, new_4_anzahl, new_4_einheit, new_4_preis, new_5_artikelnummer, new_5_bezeichnung,
                new_5_farbe, new_5_anzahl, new_5_einheit, new_5_preis, bemerkung);

        
       /**
        * Umwandlung vom Document zum Bill
        */
       DocumentToBill dtb = new DocumentToBill();
       Bill bill = dtb.documentToBill(newBill);
       
       

        
        

        // Daten an JSP Datei übergeben
        request.setAttribute("Bill", bill);
        request.getRequestDispatcher("showBill.jsp").forward(request, response);

    }
}
