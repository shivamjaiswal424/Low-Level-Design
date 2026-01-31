package com.lld.Group;

import com.lld.Expense.Expense;
import com.lld.Expense.ExpenseController;
import com.lld.Expense.ExpenseSplitType;
import com.lld.Expense.Split.Split;
import com.lld.User.User;

import java.util.ArrayList;
import java.util.List;

public class Group {
    String groupId;
    String groupName;
    List<User> userList;
    List<Expense> expenseList;
    ExpenseController expenseController;
    Group(){
        userList=new ArrayList<User>();
        expenseList=new ArrayList<>();
        expenseController=new ExpenseController();
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public List<Expense> getExpenseList() {
        return expenseList;
    }

    public void setExpenseList(List<Expense> expenseList) {
        this.expenseList = expenseList;
    }

    public ExpenseController getExpenseController() {
        return expenseController;
    }

    public void setExpenseController(ExpenseController expenseController) {
        this.expenseController = expenseController;
    }
    public void addMember(User user){
        userList.add(user);
    }
    public Expense createExpense(String expenseId, String description, double expenseAmount,
                                 List<Split> splitDetails, ExpenseSplitType splitType, User paidByUser) throws Exception {
        Expense expense=expenseController.createExpense(expenseId,description,expenseAmount,paidByUser,splitType,splitDetails);
        expenseList.add(expense);
        return expense;
    }
}
