package com.bsu.tests;

import com.bsu.main.Main;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void testMain() {

        double x, eps;
        double expected, actual;

        for (int i = -9; i <= 9; ++i) {

            x = i / 10;
            eps = Math.pow(10, -i - 10)

            expected = Main.calculateActualValue(x);
            actual = Main.calculateTailorSeries(eps, x);

            assertEquals(expected, actual);
        }

    }

}