package com.lld.User;

import com.lld.UserExpenseBalanceSheet;

public class User {
    String username;
    String userId;
    UserExpenseBalanceSheet userExpenseBalanceSheet;
    public User(String username, String userId) {
        this.username = username;
        this.userId = userId;
        userExpenseBalanceSheet = new UserExpenseBalanceSheet();
    }





    public String getUserId() {
        return userId;
    }



    public UserExpenseBalanceSheet getUserExpenseBalanceSheet() {
        return userExpenseBalanceSheet;
    }


}
