package com.sparta.engineering72;

import com.sparta.engineering72.Simulation.Simulator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DeathTest{
    @Test
    public void deathTestBefore1Year() {
        Simulator.runSimulation(11,1);
        Assertions.assertEquals(true,Simulator.FoxLifeCycle.rabbitsHunted == 0);
    }
    @Test
    public void deathTestAfter1Year() {
        Simulator.runSimulation(13, 1);
        Assertions.assertEquals(true,Simulator.FoxLifeCycle.rabbitsHunted <= 20);
    }

    @Test
    public void NaturalRabbitDeathsTest() {
        Simulator.runSimulation(61, 1);
        Assertions.assertEquals(true,Simulator.RabbitLifeCycle.naturalDeathCount <= 2);
    }

    @Test
    public void FoxLivesBeforeFiveYears() {
        Simulator.runSimulation(59, 1);
        Assertions.assertEquals(true, FoxLifeCycle.FoxDeathCount == 0);
    }
    @Test
    public void FoxDiesAfterFiveYears() {
        Simulator.runSimulation(61, 1);
        Assertions.assertEquals(true, FoxLifeCycle.FoxDeathCount == 2);
    }

}
