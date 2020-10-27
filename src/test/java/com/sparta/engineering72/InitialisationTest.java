package com.sparta.engineering72;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class InitialisationTest {
    @Test
    public void initialisationTest() {
        Assertions.assertEquals(2, Simulator.runSimulation(2));
    }
}
