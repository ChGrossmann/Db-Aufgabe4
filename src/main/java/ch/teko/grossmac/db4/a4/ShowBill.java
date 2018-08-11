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
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ch.grossmann
 */
@WebServlet(name = "ShowBill", urlPatterns = {"/ShowBill"})
public class ShowBill extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
       int billNumber = (Integer) request.getAttribute("anzeigen");
        
       BillDao billDao = new BillDao();
       DocumentToBill dtb = new DocumentToBill();
       Bill bill = dtb.documentToBill(billDao.searchBillNr(billNumber));
       
        
        
        // Daten an JSP Datei übergeben
        request.setAttribute("Bill", bill);
        request.getRequestDispatcher("showBill.jsp").forward(request, response);
        
        }
    }

    


