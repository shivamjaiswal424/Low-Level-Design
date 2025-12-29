package org.example.observer;

public class PushNotificationObserver implements StockNotificationObserver{
    public final String userId;
    public final String deviceToken;

    public PushNotificationObserver(String userId, String deviceToken) {
        this.userId = userId;
        this.deviceToken = deviceToken;
    }

    @Override
    public void update() {
        sendPushNotification();
    }

    @Override
    public String getNotificationMethod() {
        return "Push Notification";
    }
    private void sendPushNotification(){
        System.out.println("!! PUSH NOTIFICATION SENT to: " + deviceToken + " - "+"Product is back in Stock! Hurry Up!!");
    }

    @Override
    public String getUserId() {
        return userId;
    }
}
