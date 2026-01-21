package org.example.AmountWithdrawal;

import org.example.components.ATM;

public class TwoThousandWithdrawProcessor extends CashWithdrawProcessor {

    public TwoThousandWithdrawProcessor(CashWithdrawProcessor nextCashWithdrawProcessor) {
        super(nextCashWithdrawProcessor);
    }
    public void withdraw(ATM atm,int remainingAmount){
        int required = remainingAmount/2000;
        int balance= remainingAmount%2000;

        if(required<=atm.getNoOfTwoThousandNotes()){
            atm.deductTwoThousandNotes(required);
        }
        else if(required>atm.getNoOfTwoThousandNotes()) {
            atm.deductTwoThousandNotes(remainingAmount);
            balance = balance + (required - atm.getNoOfTwoThousandNotes()) * 2000;
        }

        if(balance!=0){
            super.withdraw(atm,balance);
        }

    }
}
