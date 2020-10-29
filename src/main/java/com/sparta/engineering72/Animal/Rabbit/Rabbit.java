package com.sparta.engineering72.Animal.Rabbit;

import com.sparta.engineering72.Animal.Animal;

public abstract class Rabbit extends Animal {
    private static final int DEATH_AGE = 60;
    private static final int MATURITY_AGE = 3;

    public Rabbit(Gender gender) {
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

    @Override
    public void incrementAge() {
        super.incrementAge();
    }
}

