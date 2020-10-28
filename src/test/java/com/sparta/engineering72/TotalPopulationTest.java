package com.sparta.engineering72;

import com.sparta.engineering72.Simulation.Simulator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TotalPopulationTest {
    @Test
    public void TotalPopulationTest5Months()
    {
        Simulator.runSimulation(5, 1);
        int minimum = 2;
        long maximum = 16;
        long rabbitSize = Simulator.rabbitFluffle.getRabbitPopulationSize();
        long femaleRabbitSize = Simulator.rabbitFluffle.getFemaleRabbitPopulation();
        Assertions.assertTrue(rabbitSize >= minimum && rabbitSize <= maximum);
    }

    @Test
    public void TotalPopulationTest6Months()
    {
        Simulator.runSimulation(6, 1);
        long minimum = 2;
        long rabbitSize = Simulator.rabbitFluffle.getRabbitPopulationSize();
        long femaleRabbitSize = Simulator.rabbitFluffle.getFemaleRabbitPopulation();
        long maximum = femaleRabbitSize * 14;

        Assertions.assertTrue(rabbitSize >= minimum && rabbitSize <= maximum);
    }

    @Test
    public void TotalPopulationTest7Months()
    {
        Simulator.runSimulation(7, 1);

        int minimum = 2;
        int rabbitSize = Simulator.rabbitFluffle.getRabbitPopulationSize();
        long femaleRabbitSize = Simulator.rabbitFluffle.getFemaleRabbitPopulation();
        long maximum = femaleRabbitSize * 14;
        Assertions.assertTrue(rabbitSize >= minimum && rabbitSize <= maximum);
    }

    @Test
    public void TotalPopulationTest8Months()
    {
        Simulator.runSimulation(8, 1);

        int minimum = 2;
        int rabbitSize = Simulator.rabbitFluffle.getRabbitPopulationSize();
        long femaleRabbitSize = Simulator.rabbitFluffle.getFemaleRabbitPopulation();
        long maximum = femaleRabbitSize * 14;
        Assertions.assertTrue(rabbitSize >= minimum && rabbitSize <= maximum);
    }

    @Test
    public void TotalPopulationTest9Months()
    {
        Simulator.runSimulation(9, 1);

        int minimum = 2;
        int rabbitSize = Simulator.rabbitFluffle.getRabbitPopulationSize();
        long femaleRabbitSize = Simulator.rabbitFluffle.getFemaleRabbitPopulation();
        long maximum = femaleRabbitSize * 14;
        Assertions.assertTrue(rabbitSize >= minimum && rabbitSize <= maximum);
    }

    @Test
    public void TotalPopulationTest10Months()
    {
        Simulator.runSimulation(10, 1);

        int minimum = 2;
        int rabbitSize = Simulator.rabbitFluffle.getRabbitPopulationSize();
        long femaleRabbitSize = Simulator.rabbitFluffle.getFemaleRabbitPopulation();
        long maximum = femaleRabbitSize * 14;
        Assertions.assertTrue(rabbitSize >= minimum && rabbitSize <= maximum);
    }

    @Test
    public void TotalPopulationTest11Months()
    {
        Simulator.runSimulation(11, 1);

        int minimum = 2;
        int rabbitSize = Simulator.rabbitFluffle.getRabbitPopulationSize();
        long femaleRabbitSize = Simulator.rabbitFluffle.getFemaleRabbitPopulation();
        long maximum = femaleRabbitSize * 14;
        Assertions.assertTrue(rabbitSize >= minimum && rabbitSize <= maximum);
    }

    @Test
    public void TotalPopulationTest12Months()
    {
        Simulator.runSimulation(12, 1);
        int minimum = 2;
        long femaleRabbitSize = Simulator.rabbitFluffle.getFemaleRabbitPopulation();
        long maximum = femaleRabbitSize * 14;
        int rabbitSize = Simulator.rabbitFluffle.getRabbitPopulationSize();
        Assertions.assertTrue(rabbitSize >= minimum && rabbitSize <= maximum);
    }
}
