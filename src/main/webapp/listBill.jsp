<%-- 
    Document   : listBill
    Created on : 09.08.2018, 22:29:22
    Author     : ch.grossmann
--%>

<%@page import="ch.teko.grossmac.db4.a4.beans.Bill"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Meine Rechnungen</title>
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
                <th>Rechnungsnummer</th>
                <th>Kunde</th>
                <th>Anzeigen</th>
                <th>Ändern</th>
            </tr>

            <% ArrayList<Bill> bills = (ArrayList<Bill>) request.getAttribute("ListBill");%> 
            
            <%int billInt = bills.size();%>
            
            <% for(int i = 1; billInt >= i; i++){%>
            
            <% Bill bill = bills.get(i-1); %>
            <tr>
                
                <td>&nbsp;</td>
                <td><%= bill.getNumber()%></td>
                <td><%= bill.getCustomer().get("firmenname")%></td>

                
            
            <%};%>
         
            
        </table>
            
          <% }  %>
                    <form action="ShowBill">
                        <input type="number" name="billNr" placeholder="Rechnungsnummer"/>
                        <input type="submit" value="Rechnung Anzeigen" />
                    </form>
                
                    <form action="UpdateBill">
                        <input type="number" name="billNr" placeholder="Rechnungsnummer"/>
                        <input type="submit" value="Rechnung Ändern" />
                    </form>
                
      
        <form action="index.jsp">
            <button type="submit" style="color: green; font-size: 100%;">Rechnung erfassen</button>
            </form>
    </body>
</html>
