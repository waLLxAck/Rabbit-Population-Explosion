package com.sparta.engineering72;

public abstract class Rabbit extends Animal {
    private int age;
    private Gender gender;
    private static final int DEATH_AGE = 60;
    private static final int MATURITY_AGE = 3;

    public Rabbit(Gender gender) {
        super(gender);
        this.gender = gender;
        age = 0;
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
        age = super.age;
    }
}

