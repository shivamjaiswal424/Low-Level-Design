package com.lld.Expense.Split;

import com.lld.User.User;

public class Split {
    User user;
    double amountOwe;
    public Split(User user,double amountOwe){
        this.user=user;
        this.amountOwe=amountOwe;
    }
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
    public double getAmount() {
        return amountOwe;
    }
    public void setAmount(double amount) {
        this.amountOwe = amount;
    }

}
