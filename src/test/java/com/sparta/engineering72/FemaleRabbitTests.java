package com.sparta.engineering72;

import com.sparta.engineering72.Animal.Rabbit.RabbitFluffle;
import com.sparta.engineering72.Simulation.Simulator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FemaleRabbitTests {
    @Test
    public void FemaleMatureAt3MonthsTest(){
        Simulator.runSimulation(3, 1);
        Assertions.assertEquals(true, RabbitFluffle.getFemaleRabbitList().get(0).isMature());
    }

    @Test
    public void FemalePregnantTest(){
        Simulator.runSimulation(4, 1);
        Assertions.assertEquals(true, RabbitFluffle.getFemaleRabbitList().get(0).isPregnant());
    }

    @Test
    public void OneMalePerEachPregnancy(){
        Simulator.runSimulation(100, 1);
        long numberOfMales = Simulator.rabbitFluffle.getMaleRabbitPopulation();

        //long numberOfPregnantFemales = Simulator.rabbitFluffle.getPregnantCount();//TODO

        //Assertions.assertTrue(numberOfMales >= numberOfPregnantFemales);
    }

}
