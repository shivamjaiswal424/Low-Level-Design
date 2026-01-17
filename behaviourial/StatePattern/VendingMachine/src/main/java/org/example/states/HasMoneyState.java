package org.example.states;

import org.example.context.Item;
import org.example.context.VendingMachine;
import org.example.enums.Coin;

import java.util.List;

public class HasMoneyState extends State{

    public HasMoneyState(){
        System.out.println("Currently Vending Machine is in Has Money State");
    }

    @Override
    public void clickOnStartProductSelection(VendingMachine vendingMachine) throws Exception{
        vendingMachine.setVendingMachineState(new SelectionState());
    }
    @Override
    public void insertCoin(VendingMachine vendingMachine, Coin coin) throws Exception{
        System.out.println("Accept the money");
        vendingMachine.getCoinList().add(coin);
    }
    @Override
    public List<Coin> refundFullMoney(VendingMachine machine) throws Exception {
        System.out.println("Refund the money");
        machine.setVendingMachineState(new IdleState((machine)));

        return machine.getCoinList();
    }


}
