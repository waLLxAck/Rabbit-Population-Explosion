package com.sparta.engineering72;

public class Rabbit {
    private int age;
    private String gender;

    public Rabbit(String gender) {
        age = 0;
        this.gender = gender;
    }

    public Rabbit() {
        age = 0;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }
}