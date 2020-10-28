package com.sparta.engineering72;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class InitialisationTest {
    @Test
    public void initialisationTest() {
        Simulator.runSimulation(0);
        Assertions.assertEquals(2, Simulator.rabbitFluffle.getRabbitPopulationSize());
    }

    @Test
    public void initialisationMaleTest() {
        Simulator.runSimulation(0);
        Assertions.assertEquals(1, Simulator.rabbitFluffle.getMaleRabbitPopulation());
    }

    @Test
    public void initialisationFemaleTest() {
        Simulator.runSimulation(0);
        Assertions.assertEquals(1, Simulator.rabbitFluffle.getMaleRabbitPopulation());
    }

    @Test
    public void initialisationMaturityTest(){

    }

    @Test
    public void initialisationAgeTest(){

    }


}
