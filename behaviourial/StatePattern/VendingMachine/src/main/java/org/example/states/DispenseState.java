package org.example.states;

import org.example.context.Item;
import org.example.context.VendingMachine;

public class DispenseState extends State{
    DispenseState (VendingMachine vendingMachine,int code) throws Exception{
        System.out.println("Dispense State");
        dispenseProduct(vendingMachine,code);
    }

    @Override
    public Item dispenseProduct(VendingMachine vendingMachine,int code) throws Exception{
        System.out.println("Product has been dispensed");
        Item item = vendingMachine.getInventory().getItem(code);
        vendingMachine.getInventory().updateSoldOutItem(code);
        vendingMachine.setVendingMachineState(new IdleState(vendingMachine));
        return item;

    }
}
