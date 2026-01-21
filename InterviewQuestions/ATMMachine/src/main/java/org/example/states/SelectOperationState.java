package org.example.states;

import org.example.components.ATM;
import org.example.components.Card;
import org.example.enums.TransactionType;

public class SelectOperationState extends ATMState{

    private void showOperations() {
        System.out.println("Please select the Operation");
        TransactionType.showAllTransactionTypes();
    }

    @Override
    public void selectOperation(ATM atm, Card card, TransactionType type) {
        switch(type){
            case CASH_WITHDRAWL ->  {
                atm.setCurrentATMState(new CashWithdrawalState());
                break;
            }
            case BALANCE_CHECK -> {
                atm.setCurrentATMState(new CheckBalanceState());
                break;
            }
            default -> {
                System.out.println("ERROR IN SELECTION STATE");
                exit(atm);
            }
        }
    }

    @Override
    public void exit(ATM atm) {
        returnCard();
        atm.setCurrentATMState(new IdleState());
        System.out.println("Exit happens");
    }
}
