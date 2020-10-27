package com.sparta.engineering72;

import java.util.List;

public abstract class Rabbit extends Animal {
    private int age;
    private Gender gender;
    private static final int DEATH_AGE = 60;
    private static final int MATURITY_AGE = 3;

    public Rabbit() {
        age = 0;
    }

    public int getAge() {
        return age;
    }

    @Override
    public boolean isMature() {
        return this.age >= MATURITY_AGE;
    }

    @Override
    public boolean isReadyToDie() {
        return this.age >= DEATH_AGE;
    }

}