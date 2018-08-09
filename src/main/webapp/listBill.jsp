<%-- 
    Document   : listBill
    Created on : 09.08.2018, 22:29:22
    Author     : ch.grossmann
--%>

<%@page import="org.bson.Document"%>
<%@page import="ch.teko.grossmac.db4.a4.SearchBill"%>
<%@page import="ch.teko.grossmac.db4.a4.beans.Bill"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Meine Rechnungen</h1><br><br>

        <form action="SearchBill">
            <input type="submit" value="Rechnungen auflisten">
        </form>

        <% if (request.getAttribute("ListBill") != null) {%>
        <table>

            <tr>
                <th>&nbsp;</th>
                <th>rechnungsnummer</th>
                <th>kumde , Firmenname</th>
                <th>&nbsp;anzeigen</th>
                <th>&nbsp;ändern</th>
            </tr>

            <% ArrayList<Bill> bills = (ArrayList<Bill>) request.getAttribute("ListBill");%> 
            <% for (Bill b : bills) {%>


            <tr>
                <td>&nbsp;</td>
                <td><%= b.getNumber()%></td>
                <td><%= b.getCustomer().get("firmenname")%></td>

                <td>
                    <form action="showBill.jsp">
                        <button type="submit">Anzeigen</button>
                    </form>
                </td>

                <td>
                    <form action="updateBill.jsp">
                        <button type="submit">Ändern</button>
                    </form>
                </td>
            </tr>
            <%  }%>
            <%  }%>
        </table>
    </body>
</html>
