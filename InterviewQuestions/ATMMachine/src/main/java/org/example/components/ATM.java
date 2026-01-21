package org.example.components;

import org.example.states.ATMState;
import org.example.states.IdleState;

public class ATM {
    private static ATM atmObject=new ATM();
    ATMState currentATMState;
    int noOfTwoThousandNotes;
    int noOfFiveHundredNotes;
    int noOfOneHundredNotes;
    private int atmBalance;

    private ATM(){

    }

    public ATM(int atmBalance, int noOfOneHundredNotes, int noOfFiveHundredNotes, int noOfTwoThousandNotes) {
        this.atmBalance = atmBalance;
        this.noOfOneHundredNotes = noOfOneHundredNotes;
        this.noOfFiveHundredNotes = noOfFiveHundredNotes;
        this.noOfTwoThousandNotes = noOfTwoThousandNotes;
    }

    public static ATM getATMObject(){
        atmObject.setCurrentATMState(new IdleState());
        return atmObject;
    }
    public ATMState getCurrentATMState(){
        return currentATMState;
    }
    public void setCurrentATMState(ATMState currentATMState){
        this.currentATMState=currentATMState;
    }
    public int getAtmBalance(){
        return atmBalance;
    }

    public static ATM getAtmObject() {
        return atmObject;
    }

    public static void setAtmObject(ATM atmObject) {
        ATM.atmObject = atmObject;
    }

    public int getNoOfTwoThousandNotes() {
        return noOfTwoThousandNotes;
    }

    public void setNoOfTwoThousandNotes(int noOfTwoThousandNotes) {
        this.noOfTwoThousandNotes = noOfTwoThousandNotes;
    }

    public int getNoOfFiveHundredNotes() {
        return noOfFiveHundredNotes;
    }

    public void setNoOfFiveHundredNotes(int noOfFiveHundredNotes) {
        this.noOfFiveHundredNotes = noOfFiveHundredNotes;
    }

    public int getNoOfOneHundredNotes() {
        return noOfOneHundredNotes;
    }

    public void setNoOfOneHundredNotes(int noOfOneHundredNotes) {
        this.noOfOneHundredNotes = noOfOneHundredNotes;
    }

    public void setAtmBalance(int atmBalance) {
        this.atmBalance = atmBalance;
    }
    public void deductATMBalance(int amount){
        atmBalance-=amount;
    }
    public void deductTwoThousandNotes(int number){
        noOfTwoThousandNotes-=number;

    }
    public void deductFiveHundredNotes(int number){
        noOfFiveHundredNotes-=number;
    }
    public void deductOneHundredNotes(int number){

    }
    public void printCurrentATMSTATUS(){
        System.out.println("Balance: " + atmBalance);
        System.out.println("2kNotes: " + noOfTwoThousandNotes);
        System.out.println("500Notes: " + noOfFiveHundredNotes);
        System.out.println("100Notes: " + noOfOneHundredNotes);

    }
}
