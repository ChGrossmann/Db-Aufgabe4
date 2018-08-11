/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.teko.grossmac.db4.a4;

import ch.teko.grossmac.db4.a4.dao.BillDao;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.bson.Document;

/**
 *
 * @author ch.grossmann
 */
public class DeleteBill extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int billNr = Integer.parseInt(request.getParameter("billNr"));

        BillDao billDao = new BillDao();

        Document delBill = billDao.deleteBillNr(billNr);

        request.setAttribute("DeleteBill", delBill);
        request.getRequestDispatcher("deleteBill.jsp").forward(request, response);

    }

}
