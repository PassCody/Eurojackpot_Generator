package com.github.PassCody.Eurojackpot_Generator.Numbers;

import java.security.SecureRandom;
import java.util.random.RandomGenerator;

public class Randomizer {

    private final RandomGenerator randomGenerator;

    /**
     * Initializes the Randomizer with a SecureRandom instance.
     */
    public Randomizer() {
        this.randomGenerator = new SecureRandom();
    }

    /**
     * Generates a random byte array of the specified size.
     *
     * @param byteSize the size of the byte array to generate
     * @return a byte array filled with random values
     * @throws IllegalArgumentException if byteSize is negative
     */
    public byte[] getBytes(int byteSize) {
        if (byteSize < 0) {
            throw new IllegalArgumentException("Byte size must be non-negative.");
        }
        byte[] randomBytes = new byte[byteSize];
        randomGenerator.nextBytes(randomBytes);
        return randomBytes;
    }

    /**
     * Generates a random integer within a specified range.
     *
     * @param minValue the minimum value (inclusive)
     * @param maxValue the maximum value (inclusive)
     * @return a random integer within the specified range
     * @throws IllegalArgumentException if minValue is greater than maxValue
     */
    public int getInt(int minValue, int maxValue) {
        validateRange(minValue, maxValue);
        return randomGenerator.nextInt(maxValue - minValue + 1) + minValue;
    }

    /**
     * Generates a random long within a specified range.
     *
     * @param minValue the minimum value (inclusive)
     * @param maxValue the maximum value (inclusive)
     * @return a random long within the specified range
     * @throws IllegalArgumentException if minValue is greater than maxValue
     */
    public long getLong(long minValue, long maxValue) {
        validateRange(minValue, maxValue);
        return randomGenerator.nextLong(maxValue - minValue + 1) + minValue;
    }

    /**
     * Generates a random float within a specified range.
     *
     * @param minValue the minimum value (inclusive)
     * @param maxValue the maximum value (exclusive)
     * @return a random float within the specified range
     * @throws IllegalArgumentException if minValue is greater than maxValue
     */
    public float getFloat(float minValue, float maxValue) {
        validateRange(minValue, maxValue);
        return minValue + randomGenerator.nextFloat() * (maxValue - minValue);
    }

    /**
     * Generates a random double within a specified range.
     *
     * @param minValue the minimum value (inclusive)
     * @param maxValue the maximum value (exclusive)
     * @return a random double within the specified range
     * @throws IllegalArgumentException if minValue is greater than maxValue
     */
    public double getDouble(double minValue, double maxValue) {
        validateRange(minValue, maxValue);
        return minValue + randomGenerator.nextDouble() * (maxValue - minValue);
    }

    /**
     * Validates the range to ensure the minimum value is not greater than the maximum value.
     *
     * @param minValue the minimum value
     * @param maxValue the maximum value
     * @throws IllegalArgumentException if minValue is greater than maxValue
     */
    private void validateRange(double minValue, double maxValue) {
        if (minValue > maxValue) {
            throw new IllegalArgumentException("Minimum value must not be greater than maximum value.");
        }
    }
}