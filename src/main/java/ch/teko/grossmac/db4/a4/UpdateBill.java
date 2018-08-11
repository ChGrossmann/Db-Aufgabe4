/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.teko.grossmac.db4.a4;

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
 *In der UpdateBill Klasse wird durch den Parameter einer Rechnungsnummer diese gesucht um sie dann zu aktuallisieren.
 * @author ch.grossmann
 */
public class UpdateBill extends HttpServlet {

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        /**
         * Rechnungsnummer Parameter
         */
        int billNr = Integer.parseInt(request.getParameter("billNr"));

        /**
         * Hier wird nach der Rechnung gesucht.
         */
        BillDao billDao = new BillDao();
        DocumentToBill dtb = new DocumentToBill();
        List<Document> listBill = billDao.searchBillNr(billNr);

        Bill bill = dtb.documentToBill(listBill.get(0));

        // Daten an JSP Datei übergeben
        request.setAttribute("Bill", bill);
        request.getRequestDispatcher("updateBill.jsp").forward(request, response);
        
       }

        }

    

