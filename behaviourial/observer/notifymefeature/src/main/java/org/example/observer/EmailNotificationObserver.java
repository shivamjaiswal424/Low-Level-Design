package org.example.observer;

public class EmailNotificationObserver implements StockNotificationObserver{
    private final String userId;
    private final String emailAddress;

    public EmailNotificationObserver(String userId, String emailAddress) {
        this.userId = userId;
        this.emailAddress = emailAddress;
    }

    @Override
    public void update() {
        sendEmail();
    }

    @Override
    public String getNotificationMethod() {
        return "Email";
    }

    private void sendEmail(){
        System.out.println("!! Email sent to " + emailAddress + " - " + "Product us back in stock! Hurry Up!!");
    }
    @Override
    public String getUserId() {
        return userId;
    }
}
