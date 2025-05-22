package com.github.PassCody.Eurojackpot_Generator.PossibilitiesCalculator;

import java.util.*;
import java.util.stream.Collectors;

public class PCCalc extends PCVar {

    private static final double DEFAULT_VALUE = 7.142857142857143e-9;
    private final List<Integer> finalNumbers = new ArrayList<>();
    private final List<Integer> finalEuros = new ArrayList<>();

    public synchronized void calculate(List<Integer> list, boolean isEuro) {
        Map<Integer, Double> targetMap = isEuro ? super.getEuros() : super.getNumbers();
        for (Integer key : list) {
            targetMap.merge(key, DEFAULT_VALUE, Double::sum);
        }
    }

    public synchronized void putNumber(int key, double value) {
        this.getNumbers().merge(key, value, Double::sum);
    }

    public synchronized void putEuro(int key, double value) {
        this.getEuros().merge(key, value, Double::sum);
    }

    public synchronized void mergeResults(PCCalc other) {
        other.getNumbers().forEach((key, value) ->
                this.getNumbers().merge(key, value, Double::sum)
        );
        other.getEuros().forEach((key, value) ->
                this.getEuros().merge(key, value, Double::sum)
        );
    }

    public synchronized void finalizeResults() {
        this.finalNumbers.addAll(sortKeysByValue(super.getNumbers()));
        this.finalEuros.addAll(sortKeysByValue(super.getEuros()));
    }

    private synchronized List<Integer> sortKeysByValue(Map<Integer, Double> map) {
        return map.entrySet()
                .stream()
                .sorted(Map.Entry.<Integer, Double>comparingByValue().reversed())
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    public synchronized List<Integer> getSortedTopFive() {
        List<Integer> numbers = finalNumbers.stream().limit(5).collect(Collectors.toList());
        Collections.sort(numbers);
        return numbers;
    }

    public synchronized List<Integer> getSortedTopTwo() {
        List<Integer> numbers = finalEuros.stream().limit(2).collect(Collectors.toList());
        Collections.sort(numbers);
        return numbers;
    }
}
