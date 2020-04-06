package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SmartphoneTest {

    @Test
    void shouldMatchesByProducer() {
        Smartphone smartphone = new Smartphone(2, "P40", 300, "Huawei");
        assertTrue(smartphone.matches("Huawei"));
    }

    @Test
    void shouldMatchesByName() {
        Smartphone smartphone = new Smartphone(2, "P40", 300, "Huawei");
        assertFalse(smartphone.matches("P30"));
    }
}
