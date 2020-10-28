package com.sparta.engineering72.Animal;

public abstract class Animal {

    public enum Gender {
        MALE,
        FEMALE
    }

    public Gender gender;
    public int age = 0;

    public Animal(Gender gender) {
        this.gender = gender;
    }

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
