package com.sparta.engineering72.Utility;

import java.util.Random;

public class Randomizer {
    public static int[] getRandomGender(int count) {
        Random random = new Random();
        return random.ints(count, 0, 2).toArray();
    }

    public static int getPregnancyChance(double pregnancyChance) {
        Random random = new Random();
        return random.nextInt((int) (1/pregnancyChance))+1;
    }

    public static int getRandomRabbitOffspring() {
        Random random = new Random();
        return random.nextInt(14)+1;
    }

    public static int getRandomFoxOffspring() {
        Random random = new Random();
        return random.nextInt(10)+1;
    }

    public static int getRandomHunt() {
        Random random = new Random();
        return random.nextInt(20)+1;
    }
    public static int getRandomId(int idRange) {
        Random random = new Random();
        return random.nextInt(idRange);
    }

}
