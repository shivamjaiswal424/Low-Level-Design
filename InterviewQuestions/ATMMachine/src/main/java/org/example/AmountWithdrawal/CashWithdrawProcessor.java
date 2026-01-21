package org.example.AmountWithdrawal;

import org.example.components.ATM;

public abstract class CashWithdrawProcessor {
    CashWithdrawProcessor nextCashWithdrawProcessor;
    CashWithdrawProcessor(CashWithdrawProcessor nextCashWithdrawProcessor){
        this.nextCashWithdrawProcessor = nextCashWithdrawProcessor;
    }
    public void withdraw(ATM atm,int remainingAmount){
        if(nextCashWithdrawProcessor != null){
            nextCashWithdrawProcessor.withdraw(atm,remainingAmount);
        }
    }
}
