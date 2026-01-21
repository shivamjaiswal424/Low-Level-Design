package org.example;

import org.example.components.ATM;
import org.example.components.Card;
import org.example.components.User;
import org.example.components.UserBankAccount;
import org.example.enums.TransactionType;
import org.example.states.IdleState;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args) {


        ATM atm=new ATM(3500, 1, 2, 5);
        Card card=new Card();

        UserBankAccount userBankAccount=new UserBankAccount();
        userBankAccount.setBalance(3000);
        card.setUserBankAccount(userBankAccount);
        User user=new User(card,userBankAccount);
        atm.setCurrentATMState(new IdleState());

        atm.printCurrentATMSTATUS();
        atm.getCurrentATMState().insertCard(atm,card);
        atm.getCurrentATMState().authenticatePin(atm,user.getCard(),122122);
        atm.getCurrentATMState().selectOperation(atm,card, TransactionType.CASH_WITHDRAWL);
        atm.getCurrentATMState().cashWithdrawal(atm,user.getCard(),2700);
        atm.printCurrentATMSTATUS();



    }

}