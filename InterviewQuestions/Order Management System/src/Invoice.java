public class Invoice {
    int totalItemPrice;
    int totalTax;
    int totalFinalPrice;

//    public Invoice(int totalItemPrice, int totalTax, int totalFinalPrice) {
//        this.totalItemPrice = totalItemPrice;
//        this.totalTax = totalTax;
//        this.totalFinalPrice = totalFinalPrice;
//    }
    public void generateInvoice(Order order) {
        totalItemPrice=200;
        totalTax = 20;
        totalFinalPrice = 220;

    }
}
