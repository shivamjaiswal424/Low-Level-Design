package org.example;


import org.example.observable.IphoneProductObservable;
import org.example.observable.StockAvailabilityObservable;
import org.example.observer.EmailNotificationObserver;
import org.example.observer.PushNotificationObserver;
import org.example.observer.StockNotificationObserver;

public class ECommerceStockNotificationApp {
    public static void main(String[] args) {
        System.out.println("-----------------------------------------------------------------------------");
        System.out.println("###### E-commerce Store - Stock Availability Notification Feature Demo ######");

        StockAvailabilityObservable iphoneProduct=new IphoneProductObservable("ip17","iphone 17",1250,10);
        // Create observers
        StockNotificationObserver John_PUSH = new PushNotificationObserver("John123", "JohnDeviceP1");
        StockNotificationObserver Katy_PUSH = new PushNotificationObserver("Katy678", "KatyDeviceP2");
        StockNotificationObserver Jane_EMAIL = new EmailNotificationObserver("Jane783", "jane783@gmail.com");
        StockNotificationObserver George_EMAIL = new EmailNotificationObserver("George993", "george993@gmail.com");

        // Black Friday Sale - Purchase all 10 units
        iphoneProduct.purchase(10);

        boolean success = iphoneProduct.purchase(1);
        if(!success){
            iphoneProduct.addStockObserver(John_PUSH);
            iphoneProduct.addStockObserver(Katy_PUSH);
            iphoneProduct.addStockObserver(Jane_EMAIL);
            iphoneProduct.addStockObserver(George_EMAIL);

        }
        // Restock 20 units of iPhone 15
        iphoneProduct.restock(20); // All 4 observers are notified

        // Users purchase upon receiving notifications
        iphoneProduct.purchase(1); // John purchases 1 unit
        iphoneProduct.purchase(1); // Katy purchases 1 unit

        // John & Katy unsubscribe from notifications
        iphoneProduct.removeStockObserver(John_PUSH);
        iphoneProduct.removeStockObserver(Katy_PUSH);

        // NYE Sale - All 18 units sold
        iphoneProduct.purchase(18);
        iphoneProduct.restock(5); // Only Jane & George are notified

        iphoneProduct.purchase(1); // Jane purchases 1 unit
        iphoneProduct.purchase(1); // George purchases 1 unit

        // Jane & George unsubscribe from notifications
        iphoneProduct.removeStockObserver(Jane_EMAIL);
        iphoneProduct.removeStockObserver(George_EMAIL);


    }
}