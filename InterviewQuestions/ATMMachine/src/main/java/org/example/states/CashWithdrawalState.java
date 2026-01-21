package org.example.states;

import org.example.AmountWithdrawal.CashWithdrawProcessor;
import org.example.AmountWithdrawal.FiveHundredWithdrawProcessor;
import org.example.AmountWithdrawal.OneHundredWithdrawProcessor;
import org.example.AmountWithdrawal.TwoThousandWithdrawProcessor;
import org.example.components.ATM;
import org.example.components.Card;

public class CashWithdrawalState extends ATMState{
    public CashWithdrawalState() {
        System.out.println("CashWithdrawalState()");
    }
    public void cashWithdrawal(ATM atmObject, Card card,int withdrawalAmount) {
        if(atmObject.getAtmBalance()<withdrawalAmount){
            System.out.println("Insufficient fund in the ATM Machine");
            exit(atmObject);
        }
        else if(card.getBankBalance()<withdrawalAmount){
            System.out.println("Insufficient fund in the Card Machine");
            exit(atmObject);
        }
        else{
            card.deductBankBalance(withdrawalAmount);
            atmObject.deductATMBalance(withdrawalAmount);

            CashWithdrawProcessor withdrawProcessor=new TwoThousandWithdrawProcessor(new FiveHundredWithdrawProcessor(new OneHundredWithdrawProcessor(null)));
            withdrawProcessor.withdraw(atmObject,withdrawalAmount);
            exit(atmObject);
        }
    }
    @Override
    public void exit(ATM atmObject) {
        returnCard();
        atmObject.setCurrentATMState(new IdleState());
        System.out.println("CashWithdrawalState.cashWithdrawal()");
    }
    @Override
    public void returnCard() {
        System.out.println("Please collect your card");
    }

}
