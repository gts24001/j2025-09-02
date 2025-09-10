package c;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

package c;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class HybridTest {

    private Hybrid hybrid;

    @BeforeEach
    void setUp() {
        // Initialize a Hybrid object with battery 80 and fuel 50
        hybrid = new Hybrid(80, 50);
    }

    @Test
    void testInitialValues() {
        assertEquals(80, hybrid.getBatteryLevel(), "Battery level should be 80 initially");
        assertEquals(50, hybrid.getFuelLevel(), "Fuel level should be 50 initially");
        assertEquals(0, hybrid.getMilesTraveled(), "Miles traveled should be 0 initially");
    }

    @Test
    void testSetMilesTraveled() {
        hybrid.setMilesTraveled(100);
        assertEquals(100, hybrid.getMilesTraveled(), "Miles traveled should be updated to 100");
    }

    @Test
    void testChargeBattery() {
        hybrid.chargeBattery();
        assertEquals(100, hybrid.getBatteryLevel(), "Battery should be fully charged");
    }

    @Test
    void testRefuel() {
        hybrid.refuel();
        assertEquals(100, hybrid.getFuelLevel(), "Fuel tank should be full after refueling");
    }

    @Test
    void testCostSettersAndGetters() {
        hybrid.setCostPerKWh(0.12);
        hybrid.setCostPerGallon(3.5);

        assertEquals(0.12, hybrid.getCostPerKWh(), 0.0001);
        assertEquals(3.5, hybrid.getCostPerGallon(), 0.0001);
    }

    @Test
    void testCalculateMPG() {
        double mpg = hybrid.calculateMPG(120, 4); // 120 miles, 4 gallons
        assertEquals(30.0, mpg, 0.0001);
    }

    @Test
    void testCalculateMPGe() {
        double mpge = hybrid.calculateMPGe(120, 20); // 120 miles, 20 kWh
        assertEquals((120.0 / 20.0) * 33.7, mpge, 0.0001);
    }

    @Test
    void testCalculateHybridAverage() {
        double mpg = 30.0;
        double mpge = 202.2;
        double avg = hybrid.calculateHybridAverage(mpg, mpge);
        assertEquals((mpg + mpge) / 2.0, avg, 0.0001);
    }
}
