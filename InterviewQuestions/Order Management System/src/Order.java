import java.util.Map;

public class Order {
    User user;
    Address deliveryAddress;
    Map<Integer,Integer> productCategoryAndCountMap;
    Warehouse warehouse;
    Invoice invoice;
    Payment payment;
    OrderStatus orderStatus;

    public Order(User user,Warehouse warehouse) {
        this.user = user;
        this.warehouse = warehouse;
        this.productCategoryAndCountMap=user.getUserCart().productCategoryIdVsCountMap;
        this.deliveryAddress=user.userAddress;
        invoice=new Invoice();
        invoice.generateInvoice(this);

    }
    public void checkOut(){
        warehouse.removeItemFromInventory(productCategoryAndCountMap);
        boolean isPaymentSuccess=makePayement(new UPIPaymentMode());
        if(isPaymentSuccess){
            user.getUserCart().emptyCart();
        }
        else{
            warehouse.addItemToInventory(productCategoryAndCountMap);
        }
    }
    public boolean makePayement(PaymentMode paymentMode) {
        payment=new Payment(paymentMode);
        return payment.makePayment();
    }
    public void generateOrderInvoice(){
        invoice.generateInvoice(this);
    }


}
