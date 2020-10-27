package com.sparta.engineering72;

import java.util.ArrayList;

public class Simulator {
    static RabbitFluffle rabbitFluffle = new RabbitFluffle();

    public static void runSimulation(int time) {

        Rabbit maleRabbit = new MaleRabbit();
        Rabbit femaleRabbit = new FemaleRabbit();

        maleRabbit.setGender(0);
        femaleRabbit.setGender(1);

        Printer.print("Rabbit 1 = " + maleRabbit.getGender());
        Printer.print("Rabbit 2 = " + femaleRabbit.getGender());

        rabbitFluffle.addRabbit(maleRabbit);
        rabbitFluffle.addRabbit(femaleRabbit);
        Printer.print("current size of the population of rabbits is: " + rabbitFluffle.getRabbitPopulationSize());
    }
}
