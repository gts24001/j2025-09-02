package u;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.junit.Assert.assertTrue;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;


import c.Hybrid;

public class HybridTest {
    private Hybrid hybrid;
    private Hybrid hybrid1;
    private Hybrid hybrid2;

    @Before
    public void setUp() {
        hybrid = new Hybrid(50, 30);
        hybrid1 = new Hybrid(80, 50);
        hybrid2 = new Hybrid(60, 20);
    }

    @Test
    public void testConstructorSetsInitialValues() {
        // hybrid
        assertEquals(50, hybrid.getBatteryLevel());
        assertEquals(30, hybrid.getFuelLevel());
        // hybrid1
        assertEquals(80, hybrid1.getBatteryLevel());
        assertEquals(50, hybrid1.getFuelLevel());
        // hybrid2
        assertEquals(60, hybrid2.getBatteryLevel());
        assertEquals(20, hybrid2.getFuelLevel());
    }

    @Test
    public void testChargeBatterySetsBatteryTo100AndPrintsMessage() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        hybrid.chargeBattery();
        assertEquals(100, hybrid.getBatteryLevel());
        assertTrue(outContent.toString().trim().contains("Battery fully charged."));

        hybrid1.chargeBattery();
        assertEquals(100, hybrid1.getBatteryLevel());
        assertTrue(outContent.toString().trim().contains("Battery fully charged."));

        hybrid2.chargeBattery();
        assertEquals(100, hybrid2.getBatteryLevel());
        assertTrue(outContent.toString().trim().contains("Battery fully charged."));

        System.setOut(System.out);
    }

    @Test
    public void testGetBatteryLevelReturnsCorrectValue() {
        assertEquals(50, hybrid.getBatteryLevel());
        hybrid.chargeBattery();
        assertEquals(100, hybrid.getBatteryLevel());
        hybrid1.chargeBattery();
        assertEquals(100, hybrid1.getBatteryLevel());
        hybrid2.chargeBattery();
        assertEquals(100, hybrid2.getBatteryLevel());
    }

    @Test
    public void testRefuelSetsFuelTo100AndPrintsMessage() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        hybrid.refuel();
        assertEquals(100, hybrid.getFuelLevel());
        assertTrue(outContent.toString().trim().contains("Fuel tank full."));

        hybrid1.refuel();
        assertEquals(100, hybrid1.getFuelLevel());
        assertTrue(outContent.toString().trim().contains("Fuel tank full."));

        hybrid2.refuel();
        assertEquals(100, hybrid2.getFuelLevel());
        assertTrue(outContent.toString().trim().contains("Fuel tank full."));

        System.setOut(System.out);
    }

    @Test
    public void testGetFuelLevelReturnsCorrectValue() {
        assertEquals(30, hybrid.getFuelLevel());
        hybrid.refuel();
        assertEquals(100, hybrid.getFuelLevel());
        hybrid1.refuel();
        assertEquals(100, hybrid1.getFuelLevel());
        hybrid2.refuel();
        assertEquals(100, hybrid2.getFuelLevel());
    }

    // -------------------------
    // Additional tests for calculations
    // -------------------------

    @Test
    public void testCalculateMPGAndMPGeWithDifference() {
        // hybrid1: 120 miles, 4 gallons, 20 kWh
        double mpg1 = hybrid1.calculateMPG(120, 4);
        double mpge1 = hybrid1.calculateMPGe(120, 20);

        // hybrid2: 150 miles, 5 gallons, 25 kWh
        double mpg2 = hybrid2.calculateMPG(150, 5);
        double mpge2 = hybrid2.calculateMPGe(150, 25);

        // MPG and MPGe should be different
        assertNotEquals(mpg1, mpg2);
        assertNotEquals(mpge1, mpge2);

        // hybrid average calculation
        double avg1 = hybrid1.calculateHybridAverage(mpg1, mpge1);
        double avg2 = hybrid2.calculateHybridAverage(mpg2, mpge2);

        assertNotEquals(avg1, avg2);
    }

    @Test
    public void testCalculateMPG() {
        double mpg = hybrid.calculateMPG(120, 4); // 120 miles, 4 gallons
        assertEquals(30.0, mpg, 0.0001);

    }

    @Test
    public void testCalculateMPGe() {
        double mpge = hybrid.calculateMPGe(120, 20); // 120 miles, 20 kWh
        double expected = (120.0 / 20.0) * 33.7;
        assertEquals(expected, mpge, 0.0001);
    }

    @Test
    public void testCalculateHybridAverage() {
        double mpg = 30.0;
        double mpge = 202.2;
        double avg = hybrid.calculateHybridAverage(mpg, mpge);
        assertEquals((mpg + mpge) / 2.0, avg, 0.0001);
    }
}