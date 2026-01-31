package com.lld;

import java.util.HashMap;
import java.util.Map;

public class UserExpenseBalanceSheet {
    Map<String,Balance>userVsBalance;
    double totalYourExpense;
    double totalPayment;
    double totalOwe;
    double totalGetBack;

    public UserExpenseBalanceSheet() {
        this.userVsBalance = new HashMap<>();
        this.totalYourExpense = 0;
        this.totalPayment = 0;
        this.totalGetBack = 0;

    }

    public Map<String, Balance> getUserVsBalance() {
        return userVsBalance;
    }

    public void setUserVsBalance(Map<String, Balance> userVsBalance) {
        this.userVsBalance = userVsBalance;
    }

    public double getTotalYourExpense() {
        return totalYourExpense;
    }

    public void setTotalYourExpense(double totalYourExpense) {
        this.totalYourExpense = totalYourExpense;
    }

    public double getTotalPayment() {
        return totalPayment;
    }

    public void setTotalPayment(double totalPayment) {
        this.totalPayment = totalPayment;
    }

    public double getTotalOwe() {
        return totalOwe;
    }

    public void setTotalOwe(double totalOwe) {
        this.totalOwe = totalOwe;
    }

    public double getTotalGetBack() {
        return totalGetBack;
    }

    public void setTotalGetBack(double totalGetBack) {
        this.totalGetBack = totalGetBack;
    }
}
