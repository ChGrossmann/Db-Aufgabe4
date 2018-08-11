<%-- 
    Document   : deleteBill
    Created on : 11.08.2018, 18:03:31
    Author     : ch.grossmann
--%>

<%@page import="org.bson.Document"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Rechnung löschen</title>
    </head>
    <body>
        <h1>Rechnung gelöscht</h1><br><br>

        <%-- Counter wieviele Rechnungen gelöscht wurden --%>
        <%Document delBill = (Document) request.getAttribute("DeleteBill");%>


        <h3>Anzahl der gelöschten Rechnungen: <%= delBill.get("delCount")%></h3>

        <%-- Die Auswahlmöglichkeiten --%>

        <form action="index.jsp">
            <input type="submit" value="Rechnung erfassen" />
        </form>

        <form action="SearchBill">
            <input type="submit" value="Rechnungen auflisten">
        </form><br>

        <form action="ShowBill2">
            <input type="number" name="billNr" placeholder="Rechnungsnummer"/>
            <input type="submit" value="Rechnung Anzeigen" />
        </form>

        <form action="UpdateBill">
            <input type="number" name="billNr" placeholder="Rechnungsnummer"/>
            <input type="submit" value="Rechnung Ändern" />
        </form><br><br>

        <form action="DeleteBill">
            <input type="number" name="billNr" placeholder="Rechnungsnummer"/>
            <input type="submit" value="Rechnung Löschen" style="color: red;"/>
        </form><br><br>


    </body>
</html>
