/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.teko.grossmac.db4.a4;

import ch.teko.grossmac.db4.a4.beans.Bill;
import ch.teko.grossmac.db4.a4.dao.BillDao;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.bson.Document;

/**
 * In der Klasse SearchBill wird die ausgelesene Liste aller Rechnungen
 * weitergegeben.
 *
 * @author ch.grossmann
 */
public class SearchBill extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        /**
         * Hier wird nach dem Rechnungen gesucht.
         */
        BillDao dao = new BillDao();
        List<Document> bills = dao.searchBill();

        ArrayList<Bill> listBill = new ArrayList<>();

        for (Document d : bills) {

            /**
             * Das Document wird in ein Bill umgewandelt.
             */
            DocumentToBill dtb = new DocumentToBill();
            Bill bill = dtb.documentToBill(d);

            listBill.add(bill);
        }

        request.setAttribute("ListBill", listBill);
        request.getRequestDispatcher("listBill.jsp").forward(request, response);

    }
}
