package com.sparta.engineering72;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class InitialisationTest {
    @Test
    public void initialisationTest() {
        Simulator.runSimulation(0);
        Assertions.assertEquals(2, Simulator.rabbits.size());
    }
}
