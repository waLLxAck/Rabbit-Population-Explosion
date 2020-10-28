package com.sparta.engineering72;

import java.util.Random;

public class Randomizer {
    public static int getRandomGender() {
        Random random = new Random();
        return random.nextInt(2);
    }

    public static int getPregnancyChance(double pregnancyChance) {
        Random random = new Random();
        return random.nextInt((int) (1/pregnancyChance))+1;
    }

    public static int getRandomOffspring() {
        Random random = new Random();
        return random.nextInt(14)+1;
    }
}
