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
        Assertions.assertEquals(1, Simulator.rabbitFluffle.getFemaleRabbitPopulation());
    }

    @Test
    public void initialisationFemaleMaturityTest(){
        Simulator.runSimulation(0);
        Assertions.assertEquals(false, RabbitFluffle.femaleRabbitList.get(0).isMature());
    }

    @Test
    public void initialisationMaleMaturityTest(){
        Simulator.runSimulation(0);
        Assertions.assertEquals(false, RabbitFluffle.maleRabbitList.get(0).isMature());
    }

    @Test
    public void initialisationAgeTest(){
        Simulator.runSimulation(0);
        Assertions.assertEquals(0, RabbitFluffle.maleRabbitList.get(0).getAge());
    }


}
