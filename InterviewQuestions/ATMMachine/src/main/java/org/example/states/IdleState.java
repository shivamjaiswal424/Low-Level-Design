package org.example.states;

import org.example.components.ATM;
import org.example.components.Card;

public class IdleState extends ATMState{

    @Override
    public void insertCard(ATM atm, Card card){
        System.out.println("Card is inserted");
        atm.setCurrentATMState(new HasCardState());
    }
}
