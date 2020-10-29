package com.sparta.engineering72.Utility;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Randomizer {
    public static long[] getRandomGender(long count) {
        return ThreadLocalRandom.current().longs(count, 0, 2).toArray();
    }

    public static int getPregnancyChance(double pregnancyChance) {
        Random random = new Random();
        return random.nextInt((int) (1/pregnancyChance))+1;
    }

    public static int getRandomRabbitOffspring() {
        Random random = new Random();
        return random.nextInt(14)+1;
    }

    public static long[] getRandomFoxOffspring(long pregnancies) {
        Random random = new Random();
        return random.longs(pregnancies, 1, 11).toArray();
    }

    public static int getRandomHunt() {
        Random random = new Random();
        return random.nextInt(20)+1;
    }
    public static long getRandomId(long idRange) {
        return ThreadLocalRandom.current().nextLong(idRange);
    }

    public static long[] getRandomRabbitOffspring(long pregnancies) {
        Random random = new Random();
        return random.longs(pregnancies, 1, 15).toArray();
    }
}
