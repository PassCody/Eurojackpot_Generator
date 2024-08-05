package com.github.PassCody.Eurojackpot_Generator.Generator;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class TestGenerateNumbers {

    @Test
    public void testGenerateNumbersNormalCount() {
        GenerateNumbers gn = new GenerateNumbers();
        gn.executeGenerator();

        List<Integer> normalNumbers = gn.getNormalNumbers();
        assertEquals(5, normalNumbers.size(), "Es sollten 5 normale Nummern generiert werden.");
    }

    @Test
    public void testGenerateNumbersEuroCount() {
        GenerateNumbers gn = new GenerateNumbers();
        gn.executeGenerator();

        List<Integer> euroNumbers = gn.getEuroNumbers();
        assertEquals(2, euroNumbers.size(), "Es sollten 2 Euro-Nummern generiert werden.");
    }

    @Test
    public void testNormalNumbersRange() {
        GenerateNumbers gn = new GenerateNumbers();
        gn.executeGenerator();

        List<Integer> normalNumbers = gn.getNormalNumbers();
        for (int number : normalNumbers) {
            assertTrue(number >= 1 && number <= 50, "Normale Nummern sollten im Bereich 1 bis 50 liegen.");
        }
    }

    @Test
    public void testEuroNumbersRange() {
        GenerateNumbers gn = new GenerateNumbers();
        gn.executeGenerator();

        List<Integer> euroNumbers = gn.getEuroNumbers();
        for (int number : euroNumbers) {
            assertTrue(number >= 1 && number <= 12, "Euro-Nummern sollten im Bereich 1 bis 12 liegen.");
        }
    }

    @Test
    public void testUniqueNormalNumbers() {
        GenerateNumbers gn = new GenerateNumbers();
        gn.executeGenerator();

        List<Integer> normalNumbers = gn.getNormalNumbers();
        long distinctCount = normalNumbers.stream().distinct().count();
        assertEquals(5, distinctCount, "Alle normalen Nummern sollten eindeutig sein.");
    }

    @Test
    public void testUniqueEuroNumbers() {
        GenerateNumbers gn = new GenerateNumbers();
        gn.executeGenerator();

        List<Integer> euroNumbers = gn.getEuroNumbers();
        long distinctCount = euroNumbers.stream().distinct().count();
        assertEquals(2, distinctCount, "Alle Euro-Nummern sollten eindeutig sein.");
    }

    @Test
    public void testPerformance() {
        int numberOfObjects = 100000;
        long startTime = System.currentTimeMillis();

        for (int i = 0; i < numberOfObjects; i++) {
            GenerateNumbers gn = new GenerateNumbers();
            gn.executeGenerator();
        }

        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;

        System.out.println("Zeit für " + numberOfObjects + " GenerateNumbers Objekte: " + duration + " Millisekunden");

        double estimatedTimeFor140Million = (duration / (double) numberOfObjects) * 140000000;
        System.out.println("Geschätzte Zeit für 140.000.000 GenerateNumbers Objekte: " + estimatedTimeFor140Million / 1000 / 60 + " Minuten");

        // Je nach Hardware kann die Dauer variieren, hier wird ein Beispielwert von 1 Stunde als Grenze genommen
        assertTrue(estimatedTimeFor140Million / 1000 / 60 / 60 < 2, "Die geschätzte Zeit für 140 Millionen Objekte sollte unter 2 Stunden liegen.");
    }
}