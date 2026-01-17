package org.example.states;

import org.example.context.Item;
import org.example.context.VendingMachine;
import org.example.enums.Coin;

import java.util.List;

public class SelectionState extends State{

    public SelectionState(){
        System.out.println("Selecting Selection State");
    }
    @Override
    public void chooseProduct(VendingMachine vendingMachine, int codeNumber) throws Exception{
        Item item=vendingMachine.getInventory().getItem(codeNumber);
        int paidByUser=0;
        for(Coin coin: vendingMachine.getCoinList()){
            paidByUser+= coin.value;
        }
        if(paidByUser< item.getPrice()){
            System.out.println("Insufficient Amount, Product you selected is for price: " + item.getPrice() + " and you paid: " + paidByUser);
            refundFullMoney(vendingMachine);
            throw new Exception("Insufficient Amount");
        }
        else if(paidByUser>=item.getPrice()){
            if (paidByUser>item.getPrice()){
                getChange(paidByUser-item.getPrice());
            }
            vendingMachine.setVendingMachineState(new DispenseState(vendingMachine,codeNumber));
        }
    }
    @Override
    public int getChange(int returnExtraMoney) throws Exception{
        System.out.println("Returned the change in the Coin Dispense Tray: " + returnExtraMoney);
        return returnExtraMoney;
    }
    @Override
    public List<Coin> refundFullMoney(VendingMachine machine) throws Exception {
        System.out.println("Refunding full money");
        machine.setVendingMachineState(new IdleState(machine));
        return null;
    }

}
