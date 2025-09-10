package c;
import u.TestMe;

public class MainRunner {

    public static void main(String[] args) {
        System.out.println("In main of MainRunner");

        // Create a Hybrid vehicle with battery 80 and fuel 50
        Hybrid myHybrid = new Hybrid(80, 50);

        System.out.println("Initial state:");
        System.out.println("Battery Level: " + myHybrid.getBatteryLevel());
        System.out.println("Fuel Level: " + myHybrid.getFuelLevel());
        System.out.println("Miles Traveled: " + myHybrid.getMilesTraveled());

        // Simulate driving 120 miles
        myHybrid.setMilesTraveled(120);
        System.out.println("\nAfter driving 120 miles:");
        System.out.println("Miles Traveled: " + myHybrid.getMilesTraveled());

        // Charge battery and refuel
        myHybrid.chargeBattery();
        myHybrid.refuel();

        System.out.println("\nAfter charging and refueling:");
        System.out.println("Battery Level: " + myHybrid.getBatteryLevel());
        System.out.println("Fuel Level: " + myHybrid.getFuelLevel());

        // Optionally set costs
        myHybrid.setCostPerKWh(0.15);
        myHybrid.setCostPerGallon(3.5);

        System.out.println("\nCost information:");
        System.out.println("Cost per kWh: $" + myHybrid.getCostPerKWh());
        System.out.println("Cost per gallon: $" + myHybrid.getCostPerGallon());

        // Calculate MPG and MPGe
        double mpg = myHybrid.calculateMPG(120, 4); // 120 miles, 4 gallons
        double mpge = myHybrid.calculateMPGe(120, 20); // 120 miles, 20 kWh

        System.out.println("\nEfficiency:");
        System.out.println("MPG: " + mpg);
        System.out.println("MPGe: " + mpge);
        System.out.println("Hybrid average: " + myHybrid.calculateHybridAverage(mpg, mpge));


       /* TestMe tm = new TestMe(4.5);

        tm.setValue(-9.2);
        System.out.println(tm);
        System.out.print("Value = ");
        System.out.println(tm.getValue());

        if (true) {
            tm = new TestMe();
            System.out.println(tm);
            System.out.print("Value = ");
            System.out.println(tm.getValue());
        }*/


    }
}