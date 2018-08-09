

<%@page import="java.util.List"%>
<%@page import="org.bson.Document"%>
<%@page import="ch.teko.grossmac.db4.a4.beans.Bill"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Rechnung erfassen</title>
    </head>

    <body>

        <h1 style="color: green">Rechnung erfassen</h1>

        <form action="NewBill">
            <table style="width: 100%">

                <%-- Rechnungsnummer --%>
                <tr>
                    <td>
                        Rechnungsnummer
                    </td>
                    <td colspan="6">

                        <input type="number" name="rechnungsnummer" placeholder="1" value="1"/><br><br>


                    </td>
                </tr>

                <%-- Absender --%>
                <tr>
                    <td>
                        Rechnungsadresse  
                    </td>
                    <td colspan="6">

                        <input type="text" name="rechnung_firma" placeholder="a" value="a" /><br>
                        <input type="text" name="rechnung_name" placeholder="a" value="a"/><br>
                        <input type="text" name="rechnung_strasse" placeholder="a" value="a"/><br>
                        <input type="number" name="rechnung_plz" placeholder="1" value="1"/><br>
                        <input type="text" name="rechnung_ort" placeholder="a" value="a"/><br><br>

                    </td>
                </tr>
                <%-- Kunde --%>
                <tr>
                    <td>
                        Kunde
                    </td>
                    <td colspan="6">
                        <input type="text" name="kunde_firma" placeholder="a" value="a"/><br>
                        <input type="text" name="kunde_name" placeholder="a" value="a"/><br>
                        <input type="text" name="kunde_strasse" placeholder="a" value="a"/><br>
                        <input type="number" name="kunde_plz" placeholder="1" value="1"/><br>
                        <input type="text" name="kunde_ort" placeholder="a" value="a"/><br><br>
                    </td>
                </tr>

                <%-- Lieferadresse --%>
                <tr>
                    <td>
                        Lieferadresse
                    </td>
                    <td colspan="6">
                        <input type="text" name="liefer_firma" placeholder="a" value="a"/><br>
                        <input type="text" name="liefer_name" placeholder="a" value="a"/><br>
                        <input type="text" name="liefer_strasse" placeholder="a" value="a"/><br>
                        <input type="number" name="liefer_plz" placeholder="1" value="1" /><br>
                        <input type="text" name="liefer_ort" placeholder="a" value="a"/><br><br>
                    </td>
                </tr>

                <tr>
                    <td>
                        Position
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

                <%-- Positionen --%>
                <%-- 1 --%>
                <tr>
                    <td>
                        1
                    </td>
                    <td>
                        <input type="number" name="1_artikelnummer" placeholder="1" value="1"/>
                    </td>
                    <td>
                        <input type="text" name="1_bezeichnung" placeholder="a" value="a"/>
                    </td>
                    <td>
                        <input type="text" name="1_farbe" placeholder="a" value="a"/>
                    </td>
                    <td>
                        <input type="number" name="1_anzahl" placeholder="1" value="1"/>
                    </td>
                    <td>
                        <select name="1_einheit">
                            <option  placeholder="a"></option>
                            <option  value="stück">Stück</option>
                            <option value="bund" >Bund</option>
                        </select>
                    </td>
                    <td>
                        <input type="number" step="0.1" name="1_preis" placeholder="1" value="1"/>
                    </td>
                </tr>

                <%-- 2 --%>
                <tr>
                    <td>
                        2
                    </td>
                    <td>
                        <input type="number" name="2_artikelnummer" placeholder="2" value="2"/>
                    </td>
                    <td>
                        <input type="text" name="2_bezeichnung" placeholder="a" value="a"/>
                    </td>
                    <td>
                        <input type="text" name="2_farbe" placeholder="a" value="a"/>
                    </td>
                    <td>
                        <input type="number" name="2_anzahl" placeholder="1" value="1"/>
                    </td>
                    <td>
                        <select name="2_einheit">
                            <option  placeholder="a"></option>
                            <option  value="stück">Stück</option>
                            <option value="bund" >Bund</option>
                        </select>
                    </td>
                    <td>
                        <input type="number" step="0.1" name="2_preis" placeholder="2" value="2"/>
                    </td>
                </tr>

                <%-- 3 --%>
                <tr>
                    <td>
                        3
                    </td>
                    <td>
                        <input type="number" name="3_artikelnummer" placeholder="2" value="2"/>
                    </td>
                    <td>
                        <input type="text" name="3_bezeichnung" placeholder="a" value="a"/>
                    </td>
                    <td>
                        <input type="text" name="3_farbe" placeholder="a" value="a"/>
                    </td>
                    <td>
                        <input type="number" name="3_anzahl" placeholder="2" value="2"/>
                    </td>
                    <td>
                        <select name="3_einheit">
                            <option  placeholder="a"></option>
                            <option  value="stück">Stück</option>
                            <option value="bund" >Bund</option>
                        </select>
                    </td>
                    <td>
                        <input type="number" step="0.1" name="3_preis" placeholder="2" value="2" />
                    </td>
                </tr>

                <%-- 4 --%>
                <tr>
                    <td>
                        4
                    </td>
                    <td>
                        <input type="number" name="4_artikelnummer" placeholder="2" value="2"/>
                    </td>
                    <td>
                        <input type="text" name="4_bezeichnung" placeholder="a" value="a"/>
                    </td>
                    <td>
                        <input type="text" name="4_farbe" placeholder="a" value="a"/>
                    </td>
                    <td>
                        <input type="number" name="4_anzahl" placeholder="2" value="2"/>
                    </td>
                    <td>
                        <select name="4_einheit">
                            <option  placeholder="a" ></option>
                            <option  value="stück">Stück</option>
                            <option value="bund" >Bund</option>
                        </select>
                    </td>
                    <td>
                        <input type="number" step="0.1" name="4_preis" placeholder="2" value="2"/>
                    </td>
                </tr>

                <%-- 5 --%>
                <tr>
                    <td>
                        5
                    </td>
                    <td>
                        <input type="number" name="5_artikelnummer" placeholder="2" value="2"/>
                    </td>
                    <td>
                        <input type="text" name="5_bezeichnung" placeholder="a" value="a"/>
                    </td>
                    <td>
                        <input type="text" name="5_farbe" placeholder="a" value="a"/>
                    </td>
                    <td>
                        <input type="number" name="5_anzahl" placeholder="2" value="2"/>
                    <td>
                        <select name="5_einheit">
                            <option  placeholder="a"></option>
                            <option  value="stück">Stück</option>
                            <option value="bund" >Bund</option>
                        </select>
                    </td>
                    <td>
                        <input type="number" step="0.1" name="5_preis" placeholder="2" value="2"/>
                    </td>
                </tr>

                <%-- Bemerkungen --%>
                <tr>
                    <td>
                        Bemerkung
                    </td>
                    <td colspan="6">
                        <br><textarea name="bemerkung" rows="10" cols="90" placeholder="a" value="a"></textarea>
                    </td>
                </tr>


            </table>

            <input type="submit" value="Erfassen" style="color: green; font-size: 200%;" />
        </form> <br><br>



        <% if (request.getAttribute("Bill") != null) {%>
        <h1>Resultat</h1>
        <div>

            <table border="1">
                <tr>
                    <th width="70" >Artikelnummer</th>
                    <th width="200">Bezeichnung</th>
                    <th width="30">Menge</th>
                    <th width="40">Einheit</th>
                    <th width="30">Preis</th>
                </tr>
                <%  Bill bills = (Bill) request.getAttribute("Bill");
                    
                %>
                <tr>

                    <td width="70" ><%= bills.getNumber()%></td>
                    <td>&nbsp;</td>
                    <td>&nbsp;</td>
                    <td>&nbsp;</td>
                    <td>&nbsp;</td>

                </tr>
                

            </table>
            <%
                }
            %>


    </body>
</html>



