package com.sparta.engineering72;

import java.util.List;

public class MaleRabbit extends Rabbit{

    private int age;
    private Gender gender;

    {
        this.gender=Gender.MALE;
    }

    @Override
    public List<Animal> breed() {
        return null;
    }
}
