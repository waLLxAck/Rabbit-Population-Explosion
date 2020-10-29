package com.sparta.engineering72.Animal.Fox;

import com.sparta.engineering72.Animal.Animal;

public class Fox extends Animal {
    private static final int DEATH_AGE = 60;
    private static final int MATURITY_AGE = 12;

    public Fox(Gender gender) {
        this.gender = gender;
        this.age = 0;
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


