package org.example.observable;

import org.example.observer.StockNotificationObserver;

import java.util.ArrayList;
import java.util.List;

public class IphoneProductObservable implements StockAvailabilityObservable{
    private final String productId;
    private final String productName;
    private final double price;
    private final List<StockNotificationObserver> stockObservers;
    private int stockQuantity;

    public IphoneProductObservable(String productId, String productName, double price,int stockQuantity) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.stockQuantity=stockQuantity;
        this.stockObservers=new ArrayList<>();

    }

    @Override
    public void addStockObserver(StockNotificationObserver stockNotificationObserver) {
        stockObservers.add(stockNotificationObserver);
        System.out.println("[+]" + stockNotificationObserver.getUserId() + " subscribed for notifications on " + productName);
    }

    @Override
    public void removeStockObserver(StockNotificationObserver stockNotificationObserver) {
        stockObservers.remove(stockNotificationObserver);
        System.out.println("[-]" + stockNotificationObserver.getUserId() + " unsubscribed for notifications on " + productName);
    }

    @Override
    public void notifyStockObservers() {
        if(stockQuantity>0 && !stockObservers.isEmpty()){
            System.out.println("Notifying "+ stockObservers.size() + "subscribers... ");

            List<StockNotificationObserver>observersToNotify=new ArrayList<>(stockObservers);
            for(StockNotificationObserver observer:observersToNotify){
                observer.update();
            }
        }
    }

    @Override
    public boolean purchase(int quantity) {
        if(stockQuantity>=quantity){
            stockQuantity-=quantity;
            System.out.println("PURCHASE SUCCESS: " + quantity + " units of " + productName + " | " + "Remaining stock: " + stockQuantity);
            return true;
        }
        else{
            System.out.println("PURCHASE FAILED: " + productName + " is out of stock! | " + "Available Quantity: " + stockQuantity);
            return false;

        }
    }

    @Override
    public void restock(int quantity) {
        boolean wasOutOfStock=(stockQuantity==0);
        stockQuantity+=quantity;
        System.out.println("RESTOCKED: " + productName + " - Added " + quantity + " items " + " | " + "Current stock: " + stockQuantity);
        if (wasOutOfStock && stockQuantity > 0) {
            notifyStockObservers();
        }

    }
    public String getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public double getPrice() {
        return price;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }


}
