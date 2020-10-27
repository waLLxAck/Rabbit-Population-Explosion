package com.sparta.engineering72;

import java.util.ArrayList;
import java.util.List;

public class Simulator {
    static List<Rabbit> rabbits = new ArrayList<>();
    public static void runSimulation(int time) {

        Rabbit maleRabbit = new MaleRabbit();
        Rabbit femaleRabbit = new FemaleRabbit();

        maleRabbit.setGender(0);
        femaleRabbit.setGender(1);

        Printer.print("Rabbit 1 = " + maleRabbit.getGender());
        Printer.print("Rabbit 2 = " + femaleRabbit.getGender());

        rabbits.add(maleRabbit);
        rabbits.add(femaleRabbit);
    }
}
