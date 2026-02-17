public class OrderFacade {
    private final InventoryService inventory;
    private final NotificationService notification;
    private final PaymentService payment;
    private final ShippingService shipping;

    public OrderFacade(){
        inventory = new InventoryService();
        notification = new NotificationService();
        payment = new PaymentService();
        shipping = new ShippingService();
    }
    public void placeOrder(String productId,String paymentMethod){
        System.out.println("Placing Order for : " + productId);
        if (!inventory.checkStock(productId)){
            System.out.println("Product not found for : " + productId);
            return;
        }
        if(!payment.makePayment(paymentMethod)){
            System.out.println("Payment failed for : " + productId);
            return;
        }
        shipping.shipProduct(productId);
        notification.sendConfirmation(productId);
        System.out.println("Order Placed for : " + productId);


    }
}
