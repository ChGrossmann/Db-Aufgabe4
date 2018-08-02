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
 *
 * @author ch.grossmann
 */
@WebServlet(name = "NewBill", urlPatterns = {"/NewBill"})
public class NewBill extends HttpServlet {

    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        
        // Formdaten übernehmen
        String newRechnungsnummer = req.getParameter("rechnungsnummer");
        String newMandat = req.getParameter("mandat");
        String newKunde = req.getParameter("kunde");
        String newLieferadressen = req.getParameter("lieferadresse");
        String newPositionen1 = req.getParameter("positionen1");
        String newPositionen2 = req.getParameter("positionen2");
        String newPositionen3 = req.getParameter("positionen3");
        String newPositionen4 = req.getParameter("positionen4");
        String newPositionen5 = req.getParameter("positionen5");
        String newPositionen6 = req.getParameter("positionen6");
        String newPositionen7 = req.getParameter("positionen7");
        String newPositionen8 = req.getParameter("positionen8");
        String newPositionen9 = req.getParameter("positionen9");
        String newPositionen10 = req.getParameter("positionen10");
        String newBemerkung = req.getParameter("bemerkung");

        
        // DAO Layer aufrufen
        BillDao dao = new BillDao();
        List<Document> newBill = dao.newBillDao(newRechnungsnummer, newMandat, newKunde, newLieferadressen, newPositionen1, newPositionen2, newPositionen3, newPositionen4, newPositionen5,
                newBemerkung);

        // Daten an JSP Datei übergeben
        req.setAttribute("Bill", newBill);
        req.getRequestDispatcher("createBill.jsp").forward(req, resp);

}
}
