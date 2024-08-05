package com.github.PassCody.Eurojackpot_Generator.Generator;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class TestNumbers {

    @Test
    public void testSetAndGetNormalNumbers() {
        Numbers numbers = new Numbers();
        numbers.setNormalNumbers(10);
        numbers.setNormalNumbers(5);
        numbers.setNormalNumbers(20);

        List<Integer> normalNumbers = numbers.getNormalNumbers();
        assertEquals(3, normalNumbers.size(), "Es sollten 3 normale Nummern hinzugefügt worden sein.");
        assertEquals(List.of(5, 10, 20), normalNumbers, "Die normalen Nummern sollten sortiert zurückgegeben werden.");
    }

    @Test
    public void testSetAndGetEuroNumbers() {
        Numbers numbers = new Numbers();
        numbers.setEuroNumbers(2);
        numbers.setEuroNumbers(9);
        numbers.setEuroNumbers(7);

        List<Integer> euroNumbers = numbers.getEuroNumbers();
        assertEquals(3, euroNumbers.size(), "Es sollten 3 Euro-Nummern hinzugefügt worden sein.");
        assertEquals(List.of(2, 7, 9), euroNumbers, "Die Euro-Nummern sollten sortiert zurückgegeben werden.");
    }

    @Test
    public void testGetNormalNumberByIndex() {
        Numbers numbers = new Numbers();
        numbers.setNormalNumbers(10);
        numbers.setNormalNumbers(20);

        assertEquals(10, numbers.getNormalNumber(0), "Die erste normale Nummer sollte 10 sein.");
        assertEquals(20, numbers.getNormalNumber(1), "Die zweite normale Nummer sollte 20 sein.");
    }

    @Test
    public void testGetEuroNumberByIndex() {
        Numbers numbers = new Numbers();
        numbers.setEuroNumbers(3);
        numbers.setEuroNumbers(8);

        assertEquals(3, numbers.getEuroNumber(0), "Die erste Euro-Nummer sollte 3 sein.");
        assertEquals(8, numbers.getEuroNumber(1), "Die zweite Euro-Nummer sollte 8 sein.");
    }

    @Test
    public void testIsInList() {
        Numbers numbers = new Numbers();
        numbers.setNormalNumbers(15);
        numbers.setNormalNumbers(25);

        List<Integer> normalNumbers = numbers.getNormalNumbers();
        assertTrue(numbers.isInList(normalNumbers, 15), "Die Nummer 15 sollte in der Liste sein.");
        assertFalse(numbers.isInList(normalNumbers, 10), "Die Nummer 10 sollte nicht in der Liste sein.");
    }

    @Test
    public void testIsListEmpty() {
        Numbers numbers = new Numbers();
        assertTrue(numbers.isListEmpty(numbers.getNormalNumbers()), "Die Liste sollte leer sein.");

        numbers.setNormalNumbers(5);
        assertFalse(numbers.isListEmpty(numbers.getNormalNumbers()), "Die Liste sollte nicht leer sein.");
    }

    @Test
    public void testNormalNumbersAreSorted() {
        Numbers numbers = new Numbers();
        numbers.setNormalNumbers(15);
        numbers.setNormalNumbers(5);
        numbers.setNormalNumbers(25);

        List<Integer> normalNumbers = numbers.getNormalNumbers();
        assertEquals(List.of(5, 15, 25), normalNumbers, "Die normalen Nummern sollten sortiert zurückgegeben werden.");
    }

    @Test
    public void testEuroNumbersAreSorted() {
        Numbers numbers = new Numbers();
        numbers.setEuroNumbers(9);
        numbers.setEuroNumbers(2);
        numbers.setEuroNumbers(7);

        List<Integer> euroNumbers = numbers.getEuroNumbers();
        assertEquals(List.of(2, 7, 9), euroNumbers, "Die Euro-Nummern sollten sortiert zurückgegeben werden.");
    }
}