package com.github.PassCody.Eurojackpot_Generator.PossibilitiesCalculator;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class PCVar {
    private final Map<Integer, Double> numbers = new ConcurrentHashMap<>();
    private final Map<Integer, Double> euros = new ConcurrentHashMap<>();

    public void putNumber(int key, double value) {
        numbers.put(key, value);
    }

    public void putEuro(int key, double value) {
        euros.put(key, value);
    }

    public Map<Integer, Double> getNumbers() {
        return numbers;
    }

    public Map<Integer, Double> getEuros() {
        return euros;
    }
}
