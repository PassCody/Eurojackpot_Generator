package com.github.PassCody.Eurojackpot_Generator.Generator;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.stream.Collectors;

public class ProbabilityCalculator {

    private List<Integer> normalNumbers;
    private List<Integer> euroNumbers;
    private Map<Integer, Double> nNumb;
    private Map<Integer, Double> eNumb;
    private final double probability = 7.142857142857143e-7;

    public ProbabilityCalculator() {
        this.normalNumbers = new ArrayList<>();
        this.euroNumbers = new ArrayList<>();
        this.nNumb = new HashMap<>();
        this.eNumb = new HashMap<>();
    }

    public void executeCalculator(List<Integer> normalNumbers, List<Integer> euroNumbers) {
        this.normalNumbers = new ArrayList<>(normalNumbers);
        this.euroNumbers = new ArrayList<>(euroNumbers);

        calculateProbabilities(this.normalNumbers, nNumb);
        calculateProbabilities(this.euroNumbers, eNumb);

        nNumb = sortByValuesDescending(nNumb);
        eNumb = sortByValuesDescending(eNumb);
    }

    private void calculateProbabilities(List<Integer> numbers, Map<Integer, Double> numMap) {
        for (int numb : numbers) {
            numMap.merge(numb, probability, Double::sum);
        }
    }

    private Map<Integer, Double> sortByValuesDescending(Map<Integer, Double> map) {
        return map.entrySet()
                .stream()
                .sorted((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1,
                        LinkedHashMap::new
                ));
    }

    public Map<Integer, Double> getTopEntries(Map<Integer, Double> sortedMap, int differentiator) {
        int limit = differentiator == 50 ? 5 : 2;
        return sortedMap.entrySet()
                .stream()
                .limit(limit)
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1,
                        LinkedHashMap::new
                ));
    }

    public Map<Integer, Double> getNNumb() {
        return nNumb;
    }

    public Map<Integer, Double> getENumb() {
        return eNumb;
    }
}