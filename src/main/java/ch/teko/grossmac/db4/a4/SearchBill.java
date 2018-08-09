/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.teko.grossmac.db4.a4;

import ch.teko.grossmac.db4.a4.beans.Bill;
import ch.teko.grossmac.db4.a4.beans.Product;
import ch.teko.grossmac.db4.a4.dao.DBConnection;
import java.io.IOException;
import java.util.ArrayList;
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
    
    DBConnection conn = new DBConnection();

    
     @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
     /*   
        // Formdaten übernehmen
//        String searchBillReq = req.getParameter("searchBillNr");
        

        
        // DAO Layer aufrufen
        BillDao dao = new BillDao();
        List<Document> searchBill = dao.searchBillDao();

        // Daten an JSP Datei übergeben
        req.setAttribute("searchBill", searchBill);
        req.getRequestDispatcher("searchBill.jsp").forward(req, resp);
        */
        

}
}