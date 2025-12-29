package org.example.observable;


import org.example.observer.StockNotificationObserver;

public interface StockAvailabilityObservable {

    void addStockObserver(StockNotificationObserver stockNotificationObserver);
    void removeStockObserver(StockNotificationObserver stockNotificationObserver);
    void notifyStockObservers();
    boolean purchase(int quantity);
    void restock(int quantity);

}
