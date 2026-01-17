package org.example.states;

import org.example.context.Item;
import org.example.context.VendingMachine;
import org.example.enums.Coin;

import java.util.List;

public abstract class State {
    public void clickOnInsertCoinButton(VendingMachine vendingMachine) throws Exception{
    }
    public void clickOnStartProductSelection(VendingMachine vendingMachine) throws Exception{

    }
    public void insertCoin(VendingMachine vendingMachine, Coin coin) throws Exception{
    }
    public void chooseProduct(VendingMachine vendingMachine, int codeNumber) throws Exception{

    }
    public int getChange(int returnChangeMoney) throws Exception{
        return 0;
    }
    public Item dispenseProduct(VendingMachine vendingMachine,int code) throws Exception{
        return null;
    }
    public List<Coin> refundFullMoney(VendingMachine machine) throws Exception {
        // by default nothing happens
        return null;
    }

    public void updateInventory(VendingMachine vendingMachine,Item item,int code) throws Exception{
    }
}
