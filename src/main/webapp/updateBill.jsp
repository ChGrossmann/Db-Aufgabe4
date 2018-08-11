<%-- 
    Document   : updateBill
    Created on : 09.08.2018, 22:29:48
    Author     : ch.grossmann
--%>

<%@page import="ch.teko.grossmac.db4.a4.beans.Product"%>
<%@page import="java.util.ArrayList"%>
<%@page import="ch.teko.grossmac.db4.a4.beans.Bill"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Rechnung erfassen</title>
    </head>

    <body>

        <h1 style="color: green">Rechnung ändern</h1>

        <% if (request.getAttribute("Bill") != null) {%>
        <%  Bill bill = (Bill) request.getAttribute("Bill");%> 

        <form action="SaveUpdateBill">
            <table style="width: 100%">

                <%-- Rechnungsnummer --%>
                <tr>
                    <td>
                        Rechnungsnummer
                    </td>
                    <td colspan="6">

                        <input type="number" name="rechnungsnummer" value="<%= bill.getNumber()%>"/><br><br>


                    </td>
                </tr>

                <%-- Absender --%>
                <tr>
                    <td>
                        Rechnungsadresse  
                    </td>
                    <td colspan="6">

                        <input type="text" name="rechnung_firma" value="<%= bill.getMandant().get("firmenname")%>" /><br>
                        <input type="text" name="rechnung_name"  value="<%= bill.getMandant().get("name")%>"/><br>
                        <input type="text" name="rechnung_strasse"  value="<%= bill.getMandant().get("strasse")%>"/><br>
                        <input type="number" name="rechnung_plz"  value="<%= bill.getMandant().get("postleitzahl")%>"/><br>
                        <input type="text" name="rechnung_ort"  value="<%= bill.getMandant().get("ort")%>"/><br><br>

                    </td>
                </tr>
                <%-- Kunde --%>
                <tr>
                    <td>
                        Kunde
                    </td>
                    <td colspan="6">
                        <input type="text" name="kunde_firma"  value="<%= bill.getCustomer().get("firmenname")%>"/><br>
                        <input type="text" name="kunde_name"  value="<%= bill.getCustomer().get("name")%>"/><br>
                        <input type="text" name="kunde_strasse"  value="<%= bill.getCustomer().get("strasse")%>"/><br>
                        <input type="number" name="kunde_plz"  value="<%= bill.getCustomer().get("postleitzahl")%>"/><br>
                        <input type="text" name="kunde_ort"  value="<%= bill.getCustomer().get("ort")%>"/><br><br>
                    </td>
                </tr>

                <%-- Lieferadresse --%>
                <tr>
                    <td>
                        Lieferadresse
                    </td>
                    <td colspan="6">
                        <input type="text" name="liefer_firma"  value="<%= bill.getAddress().get("firmenname")%>"/><br>
                        <input type="text" name="liefer_name" value="<%= bill.getAddress().get("name")%>"/><br>
                        <input type="text" name="liefer_strasse"  value="<%= bill.getAddress().get("strasse")%>"/><br>
                        <input type="number" name="liefer_plz" value="<%= bill.getAddress().get("postleitzahl")%>" /><br>
                        <input type="text" name="liefer_ort"  value="<%= bill.getAddress().get("ort")%>"/><br><br>
                    </td>
                </tr>

                

                <tr>
                    <td>
                        &nbsp;
                    </td>
                    <td>
                        Artikelnummer
                    </td>
                    <td>
                        Bezeichnung
                    </td>
                    <td>
                        Farbe
                    </td>
                    <td>
                        Anzahl
                    </td>
                    <td>
                        Einheit
                    </td>
                    <td>
                        Preis
                    </td>
                </tr>
                
                <%  ArrayList<Product> products = (ArrayList) bill.getPositionen();%>

                <%-- Positionen --%>
                <%-- 1 --%>
                <tr>
                    <td>
                        &nbsp;
                    </td>
                    <td>
                        <input type="number" name="1_artikelnummer" value="<%= products.get(0).getArtikelNr()%>"/>
                    </td>
                    <td>
                        <input type="text" name="1_bezeichnung"  value="<%= products.get(0).getBezeichung()%>"/>
                    </td>
                    <td>
                        <input type="text" name="1_farbe"  value="<%= products.get(0).getFarbe()%>"/>
                    </td>
                    <td>
                        <input type="number" name="1_anzahl"  value="<%= products.get(0).getAnzahl()%>"/>
                    </td>
                    <td>
                        <select name="1_einheit">
                            <option value="<%= products.get(0).getEinheit()%>"><%= products.get(0).getEinheit()%></option>
                            <option  value="stück">Stück</option>
                            <option value="bund" >Bund</option>
                        </select>
                    </td>
                    <td>
                        <input type="number" step="0.1" name="1_preis"  value="<%= products.get(0).getPreis()%>"/>
                    </td>
                </tr>

                <%-- 2 --%>
                <tr>
                    <td>
                        &nbsp;
                    </td>
                    <td>
                        <input type="number" name="2_artikelnummer" value="<%= products.get(1).getArtikelNr()%>"/>
                    </td>
                    <td>
                        <input type="text" name="2_bezeichnung" value="<%= products.get(1).getBezeichung()%>"/>
                    </td>
                    <td>
                        <input type="text" name="2_farbe" value="<%= products.get(1).getFarbe()%>"/>
                    </td>
                    <td>
                        <input type="number" name="2_anzahl" value="<%= products.get(1).getAnzahl()%>"/>
                    </td>
                    <td>
                        <select name="2_einheit">
                            <option  value="<%= products.get(1).getEinheit()%>"><%= products.get(1).getEinheit()%></option>
                            <option  value="stück">Stück</option>
                            <option value="bund" >Bund</option>
                        </select>
                    </td>
                    <td>
                        <input type="number" step="0.1" name="2_preis" value="<%= products.get(1).getArtikelNr()%>"/>
                    </td>
                </tr>

                <%-- 3 --%>
                <tr>
                    <td>
                        &nbsp;
                    </td>
                    <td>
                        <input type="number" name="3_artikelnummer" value="<%= products.get(2).getArtikelNr()%>"/>
                    </td>
                    <td>
                        <input type="text" name="3_bezeichnung" value="<%= products.get(2).getBezeichung()%>"/>
                    </td>
                    <td>
                        <input type="text" name="3_farbe" value="<%= products.get(2).getFarbe()%>"/>
                    </td>
                    <td>
                        <input type="number" name="3_anzahl" value="<%= products.get(2).getAnzahl()%>"/>
                    </td>
                    <td>
                        <select name="3_einheit">
                            <option  value="<%= products.get(2).getEinheit()%>"><%= products.get(2).getEinheit()%></option>
                            <option  value="stück">Stück</option>
                            <option value="bund" >Bund</option>
                        </select>
                    </td>
                    <td>
                        <input type="number" step="0.1" name="3_preis" value="<%= products.get(2).getPreis()%>" />
                    </td>
                </tr>

                <%-- 4 --%>
                <tr>
                    <td>
                        &nbsp;
                    </td>
                    <td>
                        <input type="number" name="4_artikelnummer" value="<%= products.get(3).getArtikelNr()%>"/>
                    </td>
                    <td>
                        <input type="text" name="4_bezeichnung" value="<%= products.get(3).getBezeichung()%>"/>
                    </td>
                    <td>
                        <input type="text" name="4_farbe" value="<%= products.get(3).getFarbe()%>"/>
                    </td>
                    <td>
                        <input type="number" name="4_anzahl" value="<%= products.get(3).getAnzahl()%>"/>
                    </td>
                    <td>
                        <select name="4_einheit">
                            <option  value="<%= products.get(3).getEinheit()%>" <%= products.get(3).getEinheit()%>option>
                            <option  value="stück">Stück</option>
                            <option value="bund" >Bund</option>
                        </select>
                    </td>
                    <td>
                        <input type="number" step="0.1" name="4_preis"  value="<%= products.get(3).getPreis()%>"/>
                    </td>
                </tr>

                <%-- 5 --%>
                <tr>
                    <td>
                        &nbsp;
                    </td>
                    <td>
                        <input type="number" name="5_artikelnummer"  value="<%= products.get(4).getArtikelNr()%>"/>
                    </td>
                    <td>
                        <input type="text" name="5_bezeichnung" value="<%= products.get(4).getBezeichung()%>"/>
                    </td>
                    <td>
                        <input type="text" name="5_farbe"  value="<%= products.get(4).getFarbe()%>"/>
                    </td>
                    <td>
                        <input type="number" name="5_anzahl"  value="<%= products.get(4).getAnzahl()%>"/>
                    <td>
                        <select name="5_einheit">
                            <option  value="<%= products.get(4).getEinheit()%>"><%= products.get(4).getEinheit()%></option>
                            <option  value="stück">Stück</option>
                            <option value="bund" >Bund</option>
                        </select>
                    </td>
                    <td>
                        <input type="number" step="0.1" name="5_preis"  value="<%= products.get(4).getPreis()%>"/>
                    </td>
                </tr>

                <%-- Bemerkungen --%>
                <tr>
                    <td>
                        Bemerkung
                    </td>
                    <td colspan="6">
                        <br><textarea name="bemerkung" rows="10" cols="90" value="a"></textarea>
                    </td>
                </tr>


            </table>

            <input type="submit" value="Ändern" style="color: green; font-size: 100%;" />
        </form> <br><br>
        <%
    }else{%>
        <h1>Leider wurden keine Daten gefunden</h1>
        <%}
        %> 
        
        <%-- Die Auswahlmöglichkeiten --%>

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
