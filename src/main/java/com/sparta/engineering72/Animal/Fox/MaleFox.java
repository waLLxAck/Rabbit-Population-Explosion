package com.sparta.engineering72.Animal.Fox;

import com.sparta.engineering72.Animal.Animal;

public class MaleFox extends Fox{
    private long count;

    public MaleFox() {
        super(Animal.Gender.MALE);
        this.age = 0;
        this.count = 1;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }
}