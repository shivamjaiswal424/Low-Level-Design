package com.lld.Expense.Split;

import java.util.List;

public class EqualExpenseSplit implements ExpenseSplit {

    @Override
    public void validateSplitRequest(List<Split> splitList, double amount) throws Exception {
        double amountShouldBe=amount/ splitList.size();
        for (Split split : splitList) {
            if (split.getAmount()!=amountShouldBe) {
                //throws exception
            }
        }
    }
}
