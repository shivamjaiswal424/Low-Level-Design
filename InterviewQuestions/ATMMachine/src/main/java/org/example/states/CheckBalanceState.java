package org.example.states;

import org.example.components.ATM;
import org.example.components.Card;

public class CheckBalanceState extends ATMState{
    public CheckBalanceState() {

    }

    @Override
    public void displayBalance(ATM atm, Card card) {
        System.out.println("Your Balance is: "+card.getBankBalance());
    }

    @Override
    public void exit(ATM atm) {
        returnCard();
        atm.setCurrentATMState(new IdleState());

    }

    @Override
    public void returnCard() {
        System.out.println("Please collect your card");
    }
}
