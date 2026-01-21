package org.example.components;

public class Card {
    static int PIN_NUMBER=122122;
    private int cardNumber;
    private int cvv;
    private int expiryDate;
    private int holderName;
    private UserBankAccount userBankAccount;

    public UserBankAccount getUserBankAccount() {
        return userBankAccount;
    }

    public void setUserBankAccount(UserBankAccount userBankAccount) {
        this.userBankAccount = userBankAccount;
    }

    public int getHolderName() {
        return holderName;
    }

    public void setHolderName(int holderName) {
        this.holderName = holderName;
    }

    public int getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(int expiryDate) {
        this.expiryDate = expiryDate;
    }

    public int getCvv() {
        return cvv;
    }

    public void setCvv(int cvv) {
        this.cvv = cvv;
    }

    public int getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(int cardNumber) {
        this.cardNumber = cardNumber;
    }

    public static int getPinNumber() {
        return PIN_NUMBER;
    }

    public static void setPinNumber(int pinNumber) {
        PIN_NUMBER = pinNumber;
    }

    public boolean isCorrectPINEntered(int pin){
        return pin == PIN_NUMBER;
    }
    public int getBankBalance(){
        return userBankAccount.getBalance();
    }
    public void deductBankBalance(int amount){
        userBankAccount.withdrawlBalance(amount);
    }
}
