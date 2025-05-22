package com.github.PassCody.Eurojackpot_Generator.Numbers;

import java.util.ArrayList;
import java.util.Collections;

public class Numbers extends Randomizer {

    private final ArrayList<Integer> nNumbers = new ArrayList<>();
    private final ArrayList<Integer> eNumbers = new ArrayList<>();

    public Numbers() {
        super();
    }

    public void startGenerating() {
        this.nNumbers.addAll(generateNumbers(5, 1,50));
        this.eNumbers.addAll(generateNumbers(2, 1,12));
    }

    public ArrayList<Integer> generateNumbers(int index, int minValue, int maxValue) {
        ArrayList<Integer> list = new ArrayList<>();
        int value;
        for (int i = 0; i < index; i++) {
            do {
                value = super.getInt(minValue, maxValue);
            } while (isInList(nNumbers, value));
            list.add(value);
        }
        sortList(list);
        return list;
    }

    public void cleanLists() {
        nNumbers.clear();
        eNumbers.clear();
    }

    private boolean isInList(ArrayList<Integer> list, int value) {
        return list.contains(value);
    }

    private void sortList(ArrayList<Integer> list) {
        Collections.sort(list);
    }

    public ArrayList<Integer> getNormalNumbers() {
        return this.nNumbers;
    }

    public ArrayList<Integer> getEuroNumbers() {
        return this.eNumbers;
    }
}
