<%-- 
    Document   : showBill
    Created on : 01.08.2018, 12:06:56
    Author     : ch.grossmann
--%>

<%@page import="ch.teko.grossmac.db4.a4.beans.Product"%>
<%@page import="java.util.ArrayList"%>
<%@page import="org.bson.Document"%>
<%@page import="ch.teko.grossmac.db4.a4.beans.Bill"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Rechnung Anzeigen</title>
    </head>


    <body>
        <% if (request.getAttribute("Bill") != null) {%>
        <%  Bill bills = (Bill) request.getAttribute("Bill");%>   

        <div style="background-color: white; font-size: 72.5%; font-family: Helvetica, sans-serif; float:left; ">
            <table cellspacing="0" cellpadding="0" border="0" width="100%" style=" border: 1px solid #000" >
                <tr>
                    <%-- Titelbild der Firma --%>
                    <td width="5%">&nbsp;</td>
                    <td  width="20%" align="left"><img src="/Aufgabe4_Rechnungen/images/Logo.png" width="200" height="200" alt="Bild wurde nicht gefunden"><br><br></td>
                    <td  width="47%" align="left" style="font-size: 400%; color: green"><%= bills.getMandant().get("firmenname") %></td>
                    <td width="3%" >&nbsp;</td>
                    <td width="25%">&nbsp;</td>
                    
                </tr>
                <tr>
                    <td>&nbsp;</td>
                    <td>&nbsp;</td>
                    <td>&nbsp;</td>
                    <td>&nbsp;</td>
                    <td>&nbsp;</td>
                </tr> 
                <tr>
                    <%-- Adresse der Firma --%>
                    <td>&nbsp;</td>
                    <td><span style="font-size: 65%;text-decoration: underline;"><%= bills.getMandant().get("strasse") %>, <%= bills.getMandant().get("ort") %>, <%= bills.getMandant().get("postleitzahl") %></span>

                        <br><br>
                        <%-- Zieladresse --%>
                        <%= bills.getAddress().get("firmenname") %><br>
                        <%= bills.getAddress().get("name") %><br>
                        <%= bills.getAddress().get("strasse") %><br>
                        <%= bills.getAddress().get("postleitzahl") %> <%= bills.getAddress().get("ort") %><br>

                        <br><br><br><br><br>


                    </td>
                    <td>&nbsp;</td>

                    <%-- Trennstrich --%>
                    <td style="border-left: 1px solid #000;"></td>

                    <%-- Informationen zur Rechnung und Rechnungsadresse --%>
                    <td><span style="font-size: 100%;font-weight: bold;">
                            <%= bills.getNumber()%><br><br>
                            <%= bills.getDate()%><br><br>
                            <%= bills.getCustomer().get("firmenname") %><br>
                        <%= bills.getCustomer().get("name") %><br>
                        <%= bills.getCustomer().get("strasse") %><br>
                        <%= bills.getCustomer().get("postleitzahl") %> <%= bills.getCustomer().get("ort") %><br>
                            </td>
                            </tr> 
                            <tr>
                                <td>&nbsp;</td>
                                <td>&nbsp;</td>
                                <td>&nbsp;</td>	
                                <td>&nbsp;</td>
                                <td>&nbsp;</td>
                            </tr>  
                            <tr>
                                <td>&nbsp;</td>
                                <td>&nbsp;</td>
                                <td>&nbsp;</td>
                                <td>&nbsp;</td>
                                <td>&nbsp;</td>
                            </tr> 
                            <tr>
                                <td>&nbsp;</td>
                                <td>&nbsp;</td>
                                <td>&nbsp;</td>	
                                <td>&nbsp;</td>
                                <td>&nbsp;</td>
                            </tr> 
                            <tr>
                                <td>&nbsp;</td>
                                <td>&nbsp;</td>
                                <td>&nbsp;</td>	
                                <td>&nbsp;</td>
                                <td>&nbsp;</td>
                            </tr>
            </table>



            <table width="100%" cellspacing="0" cellpadding="0" style="border: 1px solid #000">
                <%-- Bezeichnungen der Column --%>
                <tr>
                    <td width="5%" ><strong>&nbsp;</strong></td>
                    <td width="45%" ><strong>Artikel</strong></td>
                    <td width="10%" ><strong>Anzahl</strong></td>
                    <td width="10%" ><strong>Stück</strong></td>
                    <td width="15%" ><strong>Einzelpreis <br>CHF</strong></td> 
                    <td width="15%" ><strong>Total <br>CHF</strong></td>
                </tr> 
                <%-- Trennstrich --%>
                <tr>
                    <td style="border-top: 0.5px solid #000;">&nbsp;</td>
                    <td style="border-top: 0.5px solid #000;">&nbsp;</td>
                    <td style="border-top: 0.5px solid #000;">&nbsp;</td>
                    <td style="border-top: 0.5px solid #000;">&nbsp;</td>
                    <td style="border-top: 0.5px solid #000;">&nbsp;</td>
                    <td style="border-top: 0.5px solid #000;">&nbsp;</td>
                </tr>

                
                <%  ArrayList<Product> products = (ArrayList) bills.getPositionen();
                        for (Product p : products) {     
                    %>
                    
                <%--Position 1--%>
                <tr>
                    <td>&nbsp;</td>    
                    <td>
                        - <%= p.getArtikelNr() %><br>
                        - <%= p.getBezeichung() %><br>
                        - <%= p.getFarbe() %>
                    </td>  
                    <td><%= p.getAnzahl() %></td>
                    <td><%= p.getEinheit()%></td>
                    <td><%= p.getPreis() %></td>
                    <td><%= p.getAnzahl() * p.getPreis() %></td>
                </tr>
                <tr>
                    <td style="border-bottom: 0.5px solid #000;">&nbsp;</td>
                    <td style="border-bottom: 0.5px solid #000;">&nbsp;</td>
                    <td style="border-bottom: 0.5px solid #000;">&nbsp;</td>
                    <td style="border-bottom: 0.5px solid #000;">&nbsp;</td>
                    <td style="border-bottom: 0.5px solid #000;">&nbsp;</td>
                    <td style="border-bottom: 0.5px solid #000;">&nbsp;</td>
                </tr> 
               <% }; %>
                
                

                <%-- Linie unter Artikel --%>
                <tr>
                    <td style="border-bottom: 0.5px solid #000;">&nbsp;</td>
                    <td style="border-bottom: 0.5px solid #000;">&nbsp;</td>
                    <td style="border-bottom: 0.5px solid #000;">&nbsp;</td>
                    <td style="border-bottom: 0.5px solid #000;">&nbsp;</td>
                    <td style="border-bottom: 0.5px solid #000;">&nbsp;</td>
                    <td style="border-bottom: 0.5px solid #000;">&nbsp;</td>
                </tr> 

                <tr>
                    <td>&nbsp;</td>
                    <td>&nbsp;</td>
                    <td>&nbsp;</td>
                    <td>&nbsp;</td>
                    <td>&nbsp;</td>
                    <td>&nbsp;</td>                
                </tr>
<%  ArrayList<Product> price = (ArrayList) bills.getPositionen();
                             
                    %>
                <tr>    
                    <td colspan="3"></td>  
                    <td align="left">Subtotal</td>
                    <td>&nbsp;</td>
                    <% double subtotal = price.get(0).getAnzahl()* price.get(0).getPreis() +
                    price.get(1).getAnzahl()* price.get(1).getPreis() +
                    price.get(2).getAnzahl()* price.get(2).getPreis() +
                    price.get(3).getAnzahl()* price.get(3).getPreis() +
                    price.get(4).getAnzahl()* price.get(4).getPreis(); %>
                    <td><%= subtotal %></td>

                </tr> 
                <tr>
                    <td colspan="3"></td> 
                    <td align="left">MwSt</td>
                    <td>&nbsp;</td>
                    <td><%= bills.getMwst() %></td>
                </tr>
                <%-- Berechnung des Total und MWst --%> 


                <%-- Linie unter Zwischentotal --%>
                <tr>
                    <td style="border-bottom: 0.5px solid #000;">&nbsp;</td>
                    <td style="border-bottom: 0.5px solid #000;">&nbsp;</td>
                    <td style="border-bottom: 0.5px solid #000;">&nbsp;</td>
                    <td style="border-bottom: 0.5px solid #000;">&nbsp;</td>
                    <td style="border-bottom: 0.5px solid #000;">&nbsp;</td>
                    <td style="border-bottom: 0.5px solid #000;">&nbsp;</td>
                </tr>  
                <tr>
                    <td>&nbsp;</td>
                    <td>&nbsp;</td>
                    <td>&nbsp;</td>
                    <td>&nbsp;</td>
                    <td>&nbsp;</td>
                    <td>&nbsp;</td>                
                </tr>   

                <%-- Summetotal --%>
                <tr>     
                    <td colspan="3"></td>  
                    <td align="left"><strong>Betrag MwSt</strong></td>
                    <td>&nbsp;</td>
                    <% double subtotalMwst = subtotal /100 * bills.getMwst(); %>
                    <td><%= subtotalMwst %></td>

                </tr>

                <tr>
                    <td colspan="3"></td>  
                    <td align="left"><strong>Total inkl. MwSt</strong></td> 
                    <td>&nbsp;</td>
                    <td><strong><%= subtotal + subtotalMwst %></strong></td>
                </tr>

                <%-- Linie unter Total --%>
                <tr>
                    <td style="border-bottom: 0.5px solid #000;">&nbsp;</td>
                    <td style="border-bottom: 0.5px solid #000;">&nbsp;</td>
                    <td style="border-bottom: 0.5px solid #000;">&nbsp;</td>
                    <td style="border-bottom: 0.5px solid #000;">&nbsp;</td>
                    <td style="border-bottom: 0.5px solid #000;">&nbsp;</td>
                    <td style="border-bottom: 0.5px solid #000;">&nbsp;</td>
                </tr> 

                <tr>
                    <td colspan="6"><br><br></td>
                </tr>
                <tr>	
                    <td>&nbsp;</td>				
                    <td><%= bills.getComment() %></td>  
                    <td>&nbsp;</td>
                    <td>&nbsp;</td>
                    <td><%= bills.getZahlungsbedingung() %><br>
                    <%= bills.getDanke()%></td>
                    <td>&nbsp;</td>
                </tr> 



            </table>




        </div>

                
<%
                }else{%>
                 <h1>Leider wurden keine Daten gefunden</h1>
<%}
%>               
            <form action="index.jsp">
            <button type="submit">Rechnung erfassen</button>
            </form>
    </body>
</html>
