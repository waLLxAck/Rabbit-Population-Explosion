package com.sparta.engineering72;

public class Simulator {
    public static int runSimulation(int time) {
        
        //Simulation loop
        //Add functionality inside
        for (int i = 0; i < time; i++) {
            Printer.print(time); //TBC
            Sleeper.sleep(1000); //TBC
        }

        List<Rabbit> rabbits = new ArrayList<>();
        Rabbit maleRabbit = new Rabbit("male");
        Rabbit femaleRabbit = new Rabbit("female");

        Printer.print("Rabbit 1 = " + maleRabbit.getGender());
        Printer.print("Rabbit 2 = " + femaleRabbit.getGender());

        rabbits.add(maleRabbit);
        rabbits.add(femaleRabbit);
    }
}
