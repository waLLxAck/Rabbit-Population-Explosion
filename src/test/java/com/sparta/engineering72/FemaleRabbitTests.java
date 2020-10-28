package com.sparta.engineering72;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FemaleRabbitTests {
    @Test
    public void FemaleMatureAt3MonthsTest(){
        Simulator.runSimulation(3);
        Assertions.assertEquals(true,RabbitFluffle.getFemaleRabbitList().get(0).isMature());
    }


}
