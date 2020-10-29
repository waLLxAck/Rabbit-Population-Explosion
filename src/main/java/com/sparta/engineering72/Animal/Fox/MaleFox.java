package com.sparta.engineering72.Animal.Fox;

import com.sparta.engineering72.Animal.Animal;

public class MaleFox extends Fox{
    private int count;

    public MaleFox() {
        this.gender = Animal.Gender.MALE;
        this.age = 0;
        this.count = 1;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

}
