package com.lld;

import com.lld.Expense.Split.Split;
import com.lld.User.User;

import java.util.List;
import java.util.Map;

public class BalanceSheetController {

    public void updateUserExpenseBalanceSheet(User userPaidBy, List<Split> splitList, double expenseAmount){
        UserExpenseBalanceSheet userExpenseBalanceSheet=userPaidBy.getUserExpenseBalanceSheet();
        userExpenseBalanceSheet.setTotalPayment(userExpenseBalanceSheet.getTotalPayment()+expenseAmount);
        for (Split split : splitList) {
            User userOwe=split.getUser();
            UserExpenseBalanceSheet oweUserExpenseBalanceSheet=userOwe.getUserExpenseBalanceSheet();
            double oweAmount=split.getAmount();

            if(userPaidBy.getUserId().equals(userOwe.getUserId())){
                userExpenseBalanceSheet.setTotalPayment(userExpenseBalanceSheet.getTotalPayment()+oweAmount);
            }
            else{
                userExpenseBalanceSheet.setTotalGetBack(userExpenseBalanceSheet.getTotalGetBack()+oweAmount);
                Balance userOweBalance;
                if(userExpenseBalanceSheet.getUserVsBalance().containsKey(userOwe.getUserId())){
                    userOweBalance = userExpenseBalanceSheet.getUserVsBalance().get(userOwe.getUserId());
                }
                else{
                    userOweBalance=new Balance();
                    userExpenseBalanceSheet.getUserVsBalance().put(userOwe.getUserId(), userOweBalance);
                }
                userOweBalance.setAmountGetBack(userOweBalance.getAmountOwe()+oweAmount);

                oweUserExpenseBalanceSheet.setTotalOwe(userExpenseBalanceSheet.getTotalOwe()+oweAmount);
                oweUserExpenseBalanceSheet.setTotalYourExpense(userExpenseBalanceSheet.getTotalYourExpense()+oweAmount);

                Balance userPaidBalance;
                if(oweUserExpenseBalanceSheet.getUserVsBalance().containsKey(userPaidBy.getUserId())){
                    userPaidBalance = userExpenseBalanceSheet.getUserVsBalance().get(userPaidBy.getUserId());
                }
                else{
                    userPaidBalance=new Balance();
                    oweUserExpenseBalanceSheet.getUserVsBalance().put(userPaidBy.getUserId(), userPaidBalance);
                }
                userPaidBalance.setAmountGetBack(userPaidBalance.getAmountOwe()+oweAmount);

            }
        }

    }

    public void showBalanceSheetOfUser(User user){
        System.out.println("------------------------");
        System.out.println("Balance sheet of user :" + user.getUserId());
        UserExpenseBalanceSheet userExpenseBalanceSheet=user.getUserExpenseBalanceSheet();

        System.out.println("Total payment :" + userExpenseBalanceSheet.getTotalPayment());
        System.out.println("Total Get Back :" + userExpenseBalanceSheet.getTotalGetBack());
        System.out.println("Total Your Expense :" + userExpenseBalanceSheet.getTotalYourExpense());
        System.out.println("Total Owe :" + userExpenseBalanceSheet.getTotalOwe());
        System.out.println("Total Get Back :" + userExpenseBalanceSheet.getTotalGetBack());

        for (Map.Entry<String,Balance>entry:userExpenseBalanceSheet.getUserVsBalance().entrySet()){
            String userId = entry.getKey();
            Balance balance = entry.getValue();

            System.out.println("userId: "+ userId+ " Amount get back: "+balance.getAmountGetBack()+"Amount you owe" + balance.getAmountOwe());

        }
        System.out.println("-------------------------");
    }
}
