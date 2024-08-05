package com.github.PassCody.Eurojackpot_Generator.Generator;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Numbers {
    private List<Integer> normalNumbers;
    private List<Integer> euroNumbers;

    /**
     * Constructor initializes the number lists.
     */
    public Numbers() {
        this.normalNumbers = new ArrayList<>();
        this.euroNumbers = new ArrayList<>();
    }

    /**
     * Adds a number to the normal numbers list.
     *
     * @param number The number to add.
     */
    public void setNormalNumbers(int number) {
        this.normalNumbers.add(number);
    }

    /**
     * Adds a number to the euro numbers list.
     *
     * @param number The number to add.
     */
    public void setEuroNumbers(int number) {
        this.euroNumbers.add(number);
    }

    /**
     * Gets a number from the normal numbers list by index.
     *
     * @param index The index of the number.
     * @return The number at the specified index.
     */
    public int getNormalNumber(int index) {
        return this.normalNumbers.get(index);
    }

    /**
     * Gets the sorted list of normal numbers.
     *
     * @return The sorted list of normal numbers.
     */
    public List<Integer> getNormalNumbers() {
        Collections.sort(normalNumbers);
        return this.normalNumbers;
    }

    /**
     * Gets a number from the euro numbers list by index.
     *
     * @param index The index of the number.
     * @return The number at the specified index.
     */
    public int getEuroNumber(int index) {
        return this.euroNumbers.get(index);
    }

    /**
     * Gets the sorted list of euro numbers.
     *
     * @return The sorted list of euro numbers.
     */
    public List<Integer> getEuroNumbers() {
        Collections.sort(euroNumbers);
        return this.euroNumbers;
    }

    /**
     * Checks if a number is in the given list.
     *
     * @param list   The list to check.
     * @param number The number to find.
     * @return True if the number is in the list, false otherwise.
     */
    public boolean isInList(List<Integer> list, int number) {
        return list.contains(number);
    }

    /**
     * Checks if a list is empty.
     *
     * @param list The list to check.
     * @return True if the list is empty, false otherwise.
     */
    public boolean isListEmpty(List<Integer> list) {
        return list.isEmpty();
    }
}
