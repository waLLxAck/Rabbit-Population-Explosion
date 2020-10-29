package com.sparta.engineering72.Animal.Fox;

import com.sparta.engineering72.Animal.Animal;

public class MaleFox extends Fox{

    private int age;
    private Animal.Gender gender;
    private int count;

    public MaleFox() {
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
