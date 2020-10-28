package com.sparta.engineering72;

import com.sparta.engineering72.Animal.Rabbit.Simulator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class InitialisationTest {
    @Test
    public void initialisationTest() {
        Simulator.runSimulation(0);
        Assertions.assertEquals(2, Simulator.rabbitFluffle.getRabbitPopulationSize());
    }
}
