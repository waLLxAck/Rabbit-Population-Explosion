package com.sparta.engineering72.Animal.Rabbit;

import com.sparta.engineering72.Animal.Animal;

public class MaleRabbit extends Rabbit {
    private long count;

    public MaleRabbit() {
        super(Animal.Gender.MALE);
        this.gender= Animal.Gender.MALE;
        age = 0;
        count = 1;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }
}
