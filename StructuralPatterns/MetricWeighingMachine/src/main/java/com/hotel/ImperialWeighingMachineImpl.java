package com.hotel;

public class ImperialWeighingMachineImpl implements ImperialWeighingMachine {
    double weightInPounds;
    public ImperialWeighingMachineImpl(double weightReadingScale) {
        this.weightInPounds = weightReadingScale;
    }
    @Override
    public double getWeightInPounds() {
        return weightInPounds;
    }
}
