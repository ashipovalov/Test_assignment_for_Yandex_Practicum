package net.shipovalov.assignment;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DeliveryCostCalculatorTest {

    @Test
    void testCalculateDeliveryCostDistanceLessThan2Km() {
        double cost = DeliveryCostCalculator.calculateDeliveryCost(1, 1, 0, 1);
        assertEquals(400, cost);
    }

    @Test
    void testCalculateDeliveryCostDistance10Km() {
        double cost = DeliveryCostCalculator.calculateDeliveryCost(10, 1, 0, 1);
        assertEquals(400, cost);
    }

    @Test
    void testCalculateDeliveryCostDistance30Km() {
        double cost = DeliveryCostCalculator.calculateDeliveryCost(30, 2, 0, 1);
        assertEquals(400, cost);
    }

    @Test
    void testCalculateDeliveryCostDistanceMoreThan30Km() {
        double cost = DeliveryCostCalculator.calculateDeliveryCost(35, 1, 0, 1);
        assertEquals(400, cost);
    }

    @Test
    void testCalculateDeliveryCostFragileGoodsWithin30Km() {
        double cost = DeliveryCostCalculator.calculateDeliveryCost(25, 1, 1, 1);
        assertEquals(600, cost);
    }

    @Test
    void testCalculateDeliveryCostFragileGoodsOver30Km() {
        double cost = DeliveryCostCalculator.calculateDeliveryCost(35, 1, 1, 1);
        assertEquals(-1, cost);
    }

    @Test
    void testCalculateDeliveryCostHighWorkload() {
        double cost = DeliveryCostCalculator.calculateDeliveryCost(15, 1, 0, 3);
        assertEquals(420, cost);
    }

    @Test
    void testCalculateDeliveryCostVeryHighWorkload() {
        double cost = DeliveryCostCalculator.calculateDeliveryCost(5, 2, 0, 4);
        assertEquals(480, cost);
    }

    @Test
    void testCalculateDeliveryCostLargeSizeAndFragile() {
        double cost = DeliveryCostCalculator.calculateDeliveryCost(20, 2, 1, 1);
        assertEquals(700, cost);
    }
}