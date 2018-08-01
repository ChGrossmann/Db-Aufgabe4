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
@WebServlet(name = "NewProduct", urlPatterns = {"/NewProduct"})
public class NewProduct extends HttpServlet {

    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        
        String newArtikelnummer = req.getParameter("artikelnummer");
        String newArtikelname = req.getParameter("artikelname");
        String newPreis = req.getParameter("preis");
        String newEinheit = req.getParameter("einheit");
        String newMenge = req.getParameter("menge");

        BillDao dao = new BillDao();
        List<Document> newProduct = dao.newProductDao(newArtikelnummer, newArtikelname, newPreis, newEinheit, newMenge);

        req.setAttribute("Product", newProduct);
        req.getRequestDispatcher("index.jsp").forward(req, resp);

    }


}
