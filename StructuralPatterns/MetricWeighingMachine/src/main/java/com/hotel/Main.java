package com.hotel;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        System.out.println("Adapter Design Pattern");
        double weighingScaleReading=1;
        ImperialWeighingMachineImpl imperialWeighingMachine=new ImperialWeighingMachineImpl(weighingScaleReading);
        WeightingMachineAdapterImpl weightingMachineAdapter=new WeightingMachineAdapterImpl(imperialWeighingMachine);
        System.out.println("Weight in KG: "+ weightingMachineAdapter.getWeightInPounds());
    }
}