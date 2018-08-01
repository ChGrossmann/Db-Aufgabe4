/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.teko.grossmac.db4.a4;

import ch.teko.grossmac.db4.a4.dao.BillDao;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "SearchBillNr", urlPatterns = {"/SearchBillNr"})
public class SearchBillNr extends HttpServlet {

      @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        
        // Formdaten übernehmen
        String searchBillNrReq = req.getParameter("searchBillNr");
        

        
        // DAO Layer aufrufen
        BillDao dao = new BillDao();
        List<Document> searchBillNr = dao.searchBillNrDao(searchBillNrReq);

        // Daten an JSP Datei übergeben
        req.setAttribute("searchBillNr", searchBillNr);
        req.getRequestDispatcher("searchBill.jsp").forward(req, resp);

}

}
