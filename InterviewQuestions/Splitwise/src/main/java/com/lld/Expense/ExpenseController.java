package com.lld.Expense;

import com.lld.BalanceSheetController;
import com.lld.Expense.Split.ExpenseSplit;
import com.lld.Expense.Split.Split;
import com.lld.User.User;

import java.util.List;

public class ExpenseController {
    BalanceSheetController balanceSheetController;

    public ExpenseController() {
        this.balanceSheetController = new BalanceSheetController();
    }

    public Expense createExpense(String expenseId, String description, double expenseAmount, User userPaidBy, ExpenseSplitType expenseSplitType, List<Split> splitList) throws Exception {
        ExpenseSplit expenseSplit=SplitFactory.getSplitObj(expenseSplitType);
        expenseSplit.validateSplitRequest(splitList,expenseAmount);
        Expense expense=new Expense(expenseId,description,expenseAmount,userPaidBy,expenseSplitType,splitList);
        balanceSheetController.updateUserExpenseBalanceSheet(userPaidBy,splitList,expenseAmount);
        return expense;
    }

}
