package com.sparta.engineering72;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DeathTest

{
    @Test
    public void deathTestBefore() {

        Simulator.runSimulation(59);
        Assertions.assertEquals(true,Simulator.deathCount == 0);



    }
    @Test
    public void deathTestAfter() {

        Simulator.runSimulation(61);
        Assertions.assertEquals(true,Simulator.deathCount == 2);
    }





    }

