

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

                        <input type="number" name="rechnungsnummer" /><br><br>
                        

                    </td>
                </tr>

                <%-- Absender --%>
                <tr>
                    <td>
                        Rechnungsadresse  
                    </td>
                    <td colspan="6">

                        <input type="text" name="rechnung_firma" /><br>
                        <input type="text" name="rechnung_name" /><br>
                        <input type="text" name="rechnung_strasse" /><br>
                        <input type="number" name="rechnung_plz" /><br>
                        <input type="text" name="rechnung_ort" /><br><br>

                    </td>
                </tr>
                <%-- Kunde --%>
                <tr>
                    <td>
                        Kunde
                    </td>
                    <td colspan="6">
                        <input type="text" name="kunde_firma" /><br>
                        <input type="text" name="kunde_name" /><br>
                        <input type="text" name="kunde_strasse" /><br>
                        <input type="number" name="kunde_plz" /><br>
                        <input type="text" name="kunde_ort" /><br><br>
                    </td>
                </tr>

                <%-- Lieferadresse --%>
                <tr>
                    <td>
                        Lieferadresse
                    </td>
                    <td colspan="6">
                        <input type="text" name="liefer_firma" /><br>
                        <input type="text" name="liefer_name" /><br>
                        <input type="text" name="liefer_strasse" /><br>
                        <input type="number" name="liefer_plz" /><br>
                        <input type="text" name="liefer_ort" /><br><br>
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
                        <input type="number" name="1_artikelnummer" />
                    </td>
                    <td>
                        <input type="text" name="1_bezeichnung" />
                    </td>
                    <td>
                        <input type="text" name="1_farbe" />
                    </td>
                    <td>
                        <input type="number" name="1_anzahl" />
                    </td>
                    <td>
                        <select name="1_einheit">
                            <option  value=""></option>
                            <option  value="stück">Stück</option>
                            <option value="bund" >Bund</option>
                        </select>
                    </td>
                    <td>
                        <input type="number" step="0.1" name="1_preis" />
                    </td>
                </tr>

                <%-- 2 --%>
                <tr>
                    <td>
                        2
                    </td>
                    <td>
                        <input type="number" name="2_artikelnummer" />
                    </td>
                    <td>
                        <input type="text" name="2_bezeichnung" />
                    </td>
                    <td>
                        <input type="text" name="2_farbe" />
                    </td>
                    <td>
                        <input type="number" name="2_anzahl" />
                    </td>
                    <td>
                        <select name="2_einheit">
                            <option  value=""></option>
                            <option  value="stück">Stück</option>
                            <option value="bund" >Bund</option>
                        </select>
                    </td>
                    <td>
                        <input type="number" step="0.1" name="2_preis" />
                    </td>
                </tr>

                <%-- 3 --%>
                <tr>
                    <td>
                        3
                    </td>
                    <td>
                        <input type="number" name="3_artikelnummer" />
                    </td>
                    <td>
                        <input type="text" name="3_bezeichnung" />
                    </td>
                    <td>
                        <input type="text" name="3_farbe" />
                    </td>
                    <td>
                        <input type="number" name="3_anzahl" />
                    </td>
                    <td>
                        <select name="3_einheit">
                            <option  value=""></option>
                            <option  value="stück">Stück</option>
                            <option value="bund" >Bund</option>
                        </select>
                    </td>
                    <td>
                        <input type="number" step="0.1" name="3_preis"  />
                    </td>
                </tr>

                <%-- 4 --%>
                <tr>
                    <td>
                        4
                    </td>
                    <td>
                        <input type="number" name="4_artikelnummer" />
                    </td>
                    <td>
                        <input type="text" name="4_bezeichnung" />
                    </td>
                    <td>
                        <input type="text" name="4_farbe" />
                    </td>
                    <td>
                        <input type="number" name="4_anzahl" />
                    </td>
                    <td>
                        <select name="4_einheit">
                            <option  value=""></option>
                            <option  value="stück">Stück</option>
                            <option value="bund" >Bund</option>
                        </select>
                    </td>
                    <td>
                        <input type="number" step="0.1" name="4_preis" />
                    </td>
                </tr>

                <%-- 5 --%>
                <tr>
                    <td>
                        5
                    </td>
                    <td>
                        <input type="number" name="5_artikelnummer" />
                    </td>
                    <td>
                        <input type="text" name="5_bezeichnung" />
                    </td>
                    <td>
                        <input type="text" name="5_farbe" />
                    </td>
                    <td>
                        <input type="number" name="5_anzahl" />
                    </td>
                    <td>
                        <select name="5_einheit">
                            <option  value=""></option>
                            <option  value="stück">Stück</option>
                            <option value="bund" >Bund</option>
                        </select>
                    </td>
                    <td>
                        <input type="number" step="0.1" name="5_preis" />
                    </td>
                </tr>

                <%-- Bemerkungen --%>
                <tr>
                    <td>
                        Bemerkung
                    </td>
                    <td colspan="6">
                        <br><textarea name="bemerkung" rows="10" cols="90"></textarea>
                    </td>
                </tr>


            </table>

                <input type="submit" value="Erfassen" style="color: green; font-size: 200%;" />
        </form> 


    </body>
</html>



