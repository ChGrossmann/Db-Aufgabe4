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
@WebServlet(name = "NewMandat", urlPatterns = {"/NewMandat"})
public class NewMandat extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String newFirmenname = req.getParameter("firmenname");
        String newStrasse = req.getParameter("strasse");
        String newPlz = req.getParameter("plz");
        String newOrt = req.getParameter("ort");
        String newTelefon = req.getParameter("telefon");

        BillDao dao = new BillDao();
        List<Document> newMandat = dao.newMandatDao(newFirmenname, newStrasse, newPlz, newOrt, newTelefon);

        req.setAttribute("Mandat", newMandat);
        req.getRequestDispatcher("index.jsp").forward(req, resp);

    }
}
