package com.lld.Expense;

import com.lld.Expense.Split.Split;
import com.lld.User.User;

import java.util.ArrayList;
import java.util.List;

public class Expense {
    private String expenseId;
    private String description;
    private double amount;
    private User paidByUser;
    private ExpenseSplitType expenseSplitType;
    List<Split> splitList=new ArrayList<>();

    public Expense(String expenseId, String description, double amount, User paidByUser, ExpenseSplitType expenseSplitType,List<Split> splitDetails) {
        this.expenseId = expenseId;
        this.description = description;
        this.amount = amount;
        this.paidByUser = paidByUser;
        this.expenseSplitType = expenseSplitType;
        this.splitList.addAll(splitDetails);

    }

    public String getExpenseId() {
        return expenseId;
    }

    public void setExpenseId(String expenseId) {
        this.expenseId = expenseId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public User getPaidByUser() {
        return paidByUser;
    }

    public void setPaidByUser(User paidByUser) {
        this.paidByUser = paidByUser;
    }

    public ExpenseSplitType getExpenseSplitType() {
        return expenseSplitType;
    }

    public void setExpenseSplitType(ExpenseSplitType expenseSplitType) {
        this.expenseSplitType = expenseSplitType;
    }

    public List<Split> getSplitList() {
        return splitList;
    }

    public void setSplitList(List<Split> splitList) {
        this.splitList = splitList;
    }
}
