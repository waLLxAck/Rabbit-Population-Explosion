package com.sparta.engineering72;

import java.util.List;

public class FemaleRabbit extends Rabbit {
    private int age;
    private Gender gender;

    {
        this.gender=Gender.FEMALE;
    }

    @Override
    public List<Animal> breed() {
        return null;
    }
}
