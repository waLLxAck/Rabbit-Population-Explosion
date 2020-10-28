package com.sparta.engineering72.Animal.Rabbit;

public class MaleRabbit extends Rabbit {

    private int age;
    private Gender gender;
    private int count;

    public MaleRabbit() {
        super(Gender.MALE);
        this.gender=Gender.MALE;
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
