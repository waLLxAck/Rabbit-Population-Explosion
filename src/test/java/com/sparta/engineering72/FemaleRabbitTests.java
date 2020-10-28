package com.sparta.engineering72;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FemaleRabbitTests {
    @Test
    public void FemaleMatureAt3MonthsTest(){
        Simulator.runSimulation(3);
        Assertions.assertEquals(true,RabbitFluffle.getFemaleRabbitList().get(0).isMature());
    }

    @Test
    public void FemalePregnantTest(){
        Simulator.runSimulation(4);
        Assertions.assertEquals(true,RabbitFluffle.getFemaleRabbitList().get(0).isPregnant());
    }

    @Test
    public void OneMalePerEachPregnancy(){
        Simulator.runSimulation(100);
        long numberOfMales = Simulator.rabbitFluffle.getMaleRabbitPopulation();

        long numberOfPregnantFemales = Simulator.rabbitFluffle.getPregnantCount();//TODO

        Assertions.assertTrue(numberOfMales >= numberOfPregnantFemales);
    }

}
