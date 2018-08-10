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
                <th>&nbsp;</th>
                <th>&nbsp;</th>
            </tr>

            <% ArrayList<Bill> bills = (ArrayList<Bill>) request.getAttribute("ListBill");%> 
            

            <% Bill bill0 = bills.get(0); %>
            <tr>
                
                <td>&nbsp;</td>
                <td><%= bill0.getNumber()%></td>
                <td><%= bill0.getCustomer().get("firmenname")%></td>

                <td>
                    <form action="ShowBill">
                        <input type="submit" name="anzeigen" value="Anzeigen" />
                    </form>
                </td>

                <td>
                    <form action="UpdateBill">
                        <input type="submit" name="ändern"value="Ändern" onclick=""/>
                    </form>
                </td>
            </tr>
            
            <% Bill bill1 = bills.get(0); %>
            <tr>
                
                <td>&nbsp;</td>
                <td><%= bill1.getNumber()%></td>
                <td><%= bill1.getCustomer().get("firmenname")%></td>

                <td>
                    <form action="ShowBill">
                        
                        <input type="submit" name="anzeigen" value="Anzeigen" />
                    </form>
                </td>

                <td>
                    <form action="UpdateBill">
                        <input type="submit" name="ändern"value="Ändern" onclick=""/>
                    </form>
                </td>
            </tr>
           
            <% Bill bill2 = bills.get(1); %>
            <tr>
                
                <td>&nbsp;</td>
                <td><%= bill2.getNumber()%></td>
                <td><%= bill2.getCustomer().get("firmenname")%></td>

                <td>
                    <form action="ShowBill">
                        <input type="submit" name="anzeigen" value="Anzeigen" />
                    </form>
                </td>

                <td>
                    <form action="UpdateBill">
                        <input type="submit" name="ändern"value="Ändern" />
                    </form>
                </td>
            </tr>
            
            <% Bill bill3 = bills.get(2); %>
            <tr>
                
                <td>&nbsp;</td>
                <td><%= bill3.getNumber()%></td>
                <td><%= bill3.getCustomer().get("firmenname")%></td>

                <td>
                    <form action="ShowBill">
                        <input type="submit" name="anzeigen" value="Anzeigen" />
                    </form>
                </td>

                <td>
                    <form action="UpdateBill">
                        <input type="submit" name="ändern"value="Ändern" />
                    </form>
                </td>
            </tr>
            
            <% Bill bill4 = bills.get(3); %>
            <tr>
                
                <td>&nbsp;</td>
                <td><%= bill4.getNumber()%></td>
                <td><%= bill4.getCustomer().get("firmenname")%></td>

                <td>
                    <form action="ShowBill">
                        <input type="submit" name="anzeigen" value="Anzeigen" />
                    </form>
                </td>

                <td>
                    <form action="UpdateBill">
                        <input type="submit" name="ändern"value="Ändern" />
                    </form>
                </td>
            </tr>
            
            <% Bill bill5 = bills.get(4); %>
            <tr>
                
                <td>&nbsp;</td>
                <td><%= bill5.getNumber()%></td>
                <td><%= bill5.getCustomer().get("firmenname")%></td>

                <td>
                    <form action="ShowBill">
                        <input type="submit" name="anzeigen" value="Anzeigen"/>
                    </form>
                </td>

                <td>
                    <form action="UpdateBill">
                        <input type="submit" name="ändern"value="Ändern" />
                    </form>
                </td>
            </tr>
            
           
            
        </table>
      <% }  %>
        <form action="index.jsp">
            <button type="submit">Rechnung erfassen</button>
            </form>
    </body>
</html>
