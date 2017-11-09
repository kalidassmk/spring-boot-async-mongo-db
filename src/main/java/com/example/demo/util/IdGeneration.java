package com.example.demo.util;


/**
 * The type Id generation.
 */
public class IdGeneration {

    /**
     * Gets the key.
     *
     * @return the key
     */
    synchronized public static String getKey() {
        return "" + System.currentTimeMillis() + getRand();
    }

    /**
     * Gets the rand.
     *
     * @return the rand
     */
    private static double getRand() {
        return Math.random();
    }

}

