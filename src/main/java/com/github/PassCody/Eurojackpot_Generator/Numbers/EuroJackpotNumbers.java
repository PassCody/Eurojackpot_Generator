package com.github.PassCody.Eurojackpot_Generator.Numbers;

import com.github.PassCody.Eurojackpot_Generator.PossibilitiesCalculator.PCCalc;

public class EuroJackpotNumbers {

    private final int maxIteration;
    private final Numbers numbers = new Numbers();

    public EuroJackpotNumbers(int maxIteration) {
        this.maxIteration = maxIteration;
    }

    public void drawingNumbers(PCCalc pcc) {
        for (int i = 0; i < maxIteration; i++) {
            numbers.startGenerating();
            pcc.calculate(numbers.getNormalNumbers(), false);
            pcc.calculate(numbers.getEuroNumbers(), true);
            numbers.cleanLists();
        }
    }
}