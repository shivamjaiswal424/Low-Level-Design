package org.example.observer;

public interface StockNotificationObserver {
    void update();
    String getNotificationMethod();
    String getUserId();
}
