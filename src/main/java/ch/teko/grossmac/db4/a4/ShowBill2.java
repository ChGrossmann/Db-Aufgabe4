package ch.teko.grossmac.db4.a4;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import ch.teko.grossmac.db4.a4.beans.Bill;
import ch.teko.grossmac.db4.a4.dao.BillDao;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.bson.Document;

/**
 * In der ShowBill Klasse wird die Anzeigen funktion gemacht. Durch den
 * Parameter billNr wird die Suche nach der bestimmten Rechnungsnummer in der
 * Datenbank gemacht.
 *
 * @author ch.grossmann
 */
public class ShowBill2 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        /**
         * Rechnungsnummer aus dem Parameter.
         */
        int billNr = Integer.parseInt(request.getParameter("billNr"));
        
        /**
         * Hier wird nach der Rechnungsnummer gesucht.
         */
        BillDao billDao = new BillDao();
        DocumentToBill dtb = new DocumentToBill();
        List<Document> listBill = billDao.searchBillNr(billNr);

        Bill bill = dtb.documentToBill(listBill.get(0));

        // Daten an JSP Datei übergeben
        request.setAttribute("Bill", bill);
        request.getRequestDispatcher("showBill.jsp").forward(request, response);

    }
}
