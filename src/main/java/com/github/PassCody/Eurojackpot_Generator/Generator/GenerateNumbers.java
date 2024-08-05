package com.github.PassCody.Eurojackpot_Generator.Generator;

import java.util.List;
import java.util.ArrayList;

public class GenerateNumbers extends Numbers {

    private static final int NORMAL_NUMB_COUNT = 5;
    private static final int EURO_NUMB_COUNT = 2;

    public GenerateNumbers() {
        super();
    }

    /**
     * Executes the number generation process for normal and euro numbers.
     */
    public void executeGenerator() {
        generateNumbers(NORMAL_NUMB_COUNT, true);
        generateNumbers(EURO_NUMB_COUNT, false);
    }

    /**
     * Generates a set of unique random numbers and adds them to the appropriate list.
     *
     * @param count       The number of random numbers to generate.
     * @param isNormalSet True if generating normal numbers, false if generating euro numbers.
     */
    private void generateNumbers(int count, boolean isNormalSet) {
        List<Integer> generatedNumbers = new ArrayList<Integer>();
        int maxNumber = isNormalSet ? 50 : 12;
        while (generatedNumbers.size() < count) {
            int number = generateRandomNumber(maxNumber);
            if (generatedNumbers.add(number)) {
                if (isNormalSet) {
                    setNormalNumbers(number);
                } else {
                    setEuroNumbers(number);
                }
            }
        }
    }

    /**
     * Generates a random number within the specified range.
     *
     * @param max The maximum number (exclusive).
     * @return A random number between 1 and max (inclusive).
     */
    private int generateRandomNumber(int max) {
        return (int) (Math.random() * max) + 1;
    }
}
