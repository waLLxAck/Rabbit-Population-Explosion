package com.sparta.engineering72;

public class Rabbit extends Animal {

    private static int age;
    private static Gender gender;


    @Override
    public boolean isMature() {
        if (age > 3) {
            return true;
        }
        return false;
    }
}
