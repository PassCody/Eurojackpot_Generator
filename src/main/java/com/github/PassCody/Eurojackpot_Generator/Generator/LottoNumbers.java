package com.github.PassCody.Eurojackpot_Generator.Generator;

import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Map;
import java.util.HashMap;
import java.util.stream.Collectors;

public class LottoNumbers {
    private List<Integer> normalNumbers = new ArrayList<>();
    private List<Integer> euroNumbers = new ArrayList<>();

    public void executeLotto(Map<Integer, Double> normalNums, Map<Integer, Double> euroNums) {
        this.normalNumbers = this.mapToList(normalNums);
        this.euroNumbers = this.mapToList(euroNums);
    }

    private List<Integer> mapToList(Map<Integer, Double> map) {
        return map.keySet().stream()
                .sorted()
                .collect(Collectors.toList());
    }

    public List<Integer> getNormalNumbers() {
        return this.normalNumbers;
    }

    public int getNormalNumber(int index) {
        return this.normalNumbers.get(index);
    }

    public List<Integer> getEuroNumbers() {
        return this.euroNumbers;
    }

    public int getEuroNumber(int index) {
        return this.euroNumbers.get(index);
    }
}