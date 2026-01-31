package com.lld.Expense;

import com.lld.Expense.Split.EqualExpenseSplit;
import com.lld.Expense.Split.ExpenseSplit;
import com.lld.Expense.Split.PercentageExpenseSplit;
import com.lld.Expense.Split.UnequalExpenseSplit;

public class SplitFactory {
    public static ExpenseSplit getSplitObj(ExpenseSplitType expenseSplitType){
        switch (expenseSplitType){
            case EQUAL ->
            {
                return  new EqualExpenseSplit();
            }
            case UNEQUAL ->
            {
                return  new UnequalExpenseSplit();
            }
            case PERCENTAGE ->
            {
                return  new PercentageExpenseSplit();
            }
            default ->
            {
                return  null;
            }
        }
    }
}
