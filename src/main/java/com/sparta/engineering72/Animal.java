package com.sparta.engineering72;

public abstract class Animal {
    /**
     * @gender
     */

    private Gender gender;
    private int age=0;

    public Gender getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }



    public abstract boolean isMature();
}
