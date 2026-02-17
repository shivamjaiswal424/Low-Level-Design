
public class EcommerceApp {
    public static void main(String[] args) {
        OrderFacade orderFacade = new OrderFacade();
        orderFacade.placeOrder("MacBook Pro","Credit card");
        orderFacade.placeOrder("Cricket Bat", "UPI");
    }
}