package com.sparta.engineering72;

import java.util.List;

public abstract class Animal {

    public enum Gender {
        MALE,
        FEMALE
    }
    private Gender gender;
    private int age = 0;

    public Gender getGender() {
        return gender;
    }

    public void setGender(int gender){
        if(gender == 0) this.gender = Gender.MALE;
        else {
            this.gender = Gender.FEMALE;
        }
    }

    public int getAge() {
        return age;
    }
    public abstract boolean isMature();

    public abstract boolean isReadyToDie();

    public void incrementAge(){
        age++;
    }

}
