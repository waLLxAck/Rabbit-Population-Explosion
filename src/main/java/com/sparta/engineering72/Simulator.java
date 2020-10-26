package com.sparta.engineering72;

import java.util.ArrayList;
import java.util.List;

public class Simulator {
    public static int runSimulation(int time) {

        List<Rabbit> rabbits = new ArrayList<>();
        Rabbit maleRabbit = new Rabbit("male");
        Rabbit femaleRabbit = new Rabbit("female");

        Printer.print("Rabbit 1 = " + maleRabbit.getGender());
        Printer.print("Rabbit 2 = " + femaleRabbit.getGender());

        rabbits.add(maleRabbit);
        rabbits.add(femaleRabbit);

        return rabbits.size();
    }
}
