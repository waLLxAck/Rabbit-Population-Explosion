package com.sparta.engineering72;

import java.util.List;

public class MaleRabbit extends Rabbit {

    private int age;
    private Gender gender;

    public MaleRabbit() {
        super(Gender.MALE);
        this.gender=Gender.MALE;
        age = 0;
    }

}
