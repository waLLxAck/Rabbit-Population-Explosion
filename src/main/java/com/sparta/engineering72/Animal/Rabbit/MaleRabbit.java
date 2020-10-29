package com.sparta.engineering72.Animal.Rabbit;

import com.sparta.engineering72.Animal.Animal;

public class MaleRabbit extends Rabbit {

    private int age;
    private Animal.Gender gender;
    private int count;

    public MaleRabbit() {
        super(Animal.Gender.MALE);
        this.gender= Animal.Gender.MALE;
        age = 0;
        count = 1;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
