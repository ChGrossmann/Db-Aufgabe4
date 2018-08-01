package ch.teko.grossmac.db4.a4.beans;

import java.util.List;
import org.bson.Document;

public class Bill {

       
    private String billNumber;
    private String billDate;
    private Document billSeller;
    private Document billCustomer;
    private Document billPlace;
    private double productPrice;
    private Document billComment;

    private List<Product> positionen;

    public String getBillNumber() {
        return billNumber;
    }

    public void setBillNumber(String billNumber) {
        this.billNumber = billNumber;
    }

    public String getBillDate() {
        return billDate;
    }

    public void setBillDate(String billDate) {
        this.billDate = billDate;
    }

    public Document getBillSeller() {
        return billSeller;
    }

    public void setBillSeller(Document billSeller) {
        this.billSeller = billSeller;
    }

    public Document getBillCustomer() {
        return billCustomer;
    }

    public void setBillCustomer(Document billCustomer) {
        this.billCustomer = billCustomer;
    }

    public Document getBillPlace() {
        return billPlace;
    }

    public void setBillPlace(Document billPlace) {
        this.billPlace = billPlace;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public Document getBillComment() {
        return billComment;
    }

    public void setBillComment(Document billComment) {
        this.billComment = billComment;
    }

    public List<Product> getPositionen() {
        return positionen;
    }

    public void setPositionen(List<Product> positionen) {
        this.positionen = positionen;
    }
    
    
    



}
