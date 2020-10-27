package com.sparta.engineering72;

public class Simulator {
<<<<<<< HEAD
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
=======
    static List<Rabbit> rabbits = new ArrayList<>();
    public static void runSimulation(int time) {

        Rabbit maleRabbit = new MaleRabbit();
        Rabbit femaleRabbit = new FemaleRabbit();

        maleRabbit.setGender(0);
        femaleRabbit.setGender(1);
>>>>>>> 627837913d101dbcbf8f90a68aa4c5a9f11e6a2c

        Printer.print("Rabbit 1 = " + maleRabbit.getGender());
        Printer.print("Rabbit 2 = " + femaleRabbit.getGender());

        rabbits.add(maleRabbit);
        rabbits.add(femaleRabbit);
    }
}
