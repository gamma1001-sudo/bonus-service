package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BonusServiceTest {
    private final BonusService service = new BonusService();

    @Test
    void shouldCalculateForRegisteredAndUnderLimit() {
        assertEquals(30, service.calculate(1_000, true));
    }

    @Test
    void shouldCalculateForRegisteredAndOverLimit() {
        assertEquals(500, service.calculate(1_000_000, true));
    }

    @Test
    void shouldCalculateForUnregisteredAndUnderLimit() {
        assertEquals(10, service.calculate(1_000, false));
    }

    @Test
    void shouldCalculateForUnregisteredAndOverLimit() {
        assertEquals(500, service.calculate(1_000_000, false));
    }

    @Test
    void shouldReturnZeroForZeroAmount() {
        assertEquals(0, service.calculate(0, true));
    }

    @Test
    void shouldCalculateRegisteredValueImmediatelyBelowLimit() {
        assertEquals(499, service.calculate(16_666, true));
    }

    @Test
    void shouldCalculateRegisteredValueAtLimit() {
        assertEquals(500, service.calculate(16_667, true));
    }
}
