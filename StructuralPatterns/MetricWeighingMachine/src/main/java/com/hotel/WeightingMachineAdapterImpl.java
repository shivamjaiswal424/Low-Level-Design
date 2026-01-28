package com.hotel;

public class WeightingMachineAdapterImpl {
    ImperialWeighingMachine imperialWeighingMachine;
    public WeightingMachineAdapterImpl(ImperialWeighingMachine imperialWeighingMachine) {
        this.imperialWeighingMachine = imperialWeighingMachine;
    }
    public double getWeightInPounds() {
        double getWeightInPounds = imperialWeighingMachine.getWeightInPounds();
        return getWeightInPounds*0.45;
    }
}
