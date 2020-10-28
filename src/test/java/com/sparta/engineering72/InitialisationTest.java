package com.sparta.engineering72;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class InitialisationTest {
    @Test
    public void initialisationTest() {
        try {
            Simulator.runSimulation(0);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Assertions.assertEquals(2, Simulator.rabbitFluffle.getRabbitPopulationSize());
    }
}
