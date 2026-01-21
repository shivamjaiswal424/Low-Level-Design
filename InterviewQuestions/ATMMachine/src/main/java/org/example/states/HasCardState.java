package org.example.states;

import org.example.components.ATM;
import org.example.components.Card;

public class HasCardState extends ATMState{
    public HasCardState() {
        System.out.println("Please enter your card number");
    }

    @Override
    public void authenticatePin(ATM atm, Card card,int pin){
        boolean isCorrectPin= card.isCorrectPINEntered(pin);
        if(isCorrectPin){
            System.out.println("Your card has been entered correctly");
            atm.setCurrentATMState(new SelectOperationState());
        }
        else{
            System.out.println("Your card has been entered incorrectly");
            exit(atm);
        }
    }

    @Override
    public void exit(ATM atm) {
        returnCard();
        atm.setCurrentATMState(new IdleState());
        System.out.println("Exit happens");
    }

    @Override
    public void returnCard() {
        System.out.println("Please collect your card");
    }
}
