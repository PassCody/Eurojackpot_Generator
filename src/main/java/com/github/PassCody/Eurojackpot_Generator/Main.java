package com.github.PassCody.Eurojackpot_Generator;

import com.github.PassCody.Eurojackpot_Generator.Numbers.EuroJackpotNumbers;
import com.github.PassCody.Eurojackpot_Generator.PossibilitiesCalculator.PCCalc;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {

    private final int MAX_TIP_ITERATION = 140000000;

    public Main() {
        PCCalc pcc = new PCCalc();
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        for (int i = 0; i < 2; i++) {
            executorService.execute(() -> {
                EuroJackpotNumbers numbers = new EuroJackpotNumbers(MAX_TIP_ITERATION);
                PCCalc localPcc = new PCCalc();
                numbers.drawingNumbers(localPcc);
                synchronized (pcc) {
                    pcc.mergeResults(localPcc);
                }
            });
        }
        executorService.shutdown();
        try {
            executorService.awaitTermination(1, TimeUnit.HOURS);
        } catch (InterruptedException e) {
            System.err.println("Thread execution interrupted: " + e.getMessage());
        }
        pcc.finalizeResults();

        System.out.println("Zahlen => " + pcc.getSortedTopFive());
        System.out.println("Eurozahl => " + pcc.getSortedTopTwo());
    }

    public static void main(String[] args) {
        new Main();
    }
}
