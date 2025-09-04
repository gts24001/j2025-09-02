package c;

public class Hybrid implements ElectricVehicle, GasVehicle {
    private int batteryLevel;
    private int fuelLevel;
    private int milesTraveled;

    public Hybrid(int batteryLevel, int fuelLevel) {
        this.batteryLevel = batteryLevel;
        this.fuelLevel = fuelLevel;
    }

    public void setMilesTraveled(int miles) {
        this.milesTraveled = miles;
    }

    public int getMilesTraveled() {
        return milesTraveled;
    }

    public int getMilesPerGallon() {
        //return milesTraveled / gallonsUsed();
        return 0;
    }

    @Override
    public void chargeBattery() {
        batteryLevel = 100;
        System.out.println("Battery fully charged.");
    }

    @Override
    public int getBatteryLevel() {
        return batteryLevel;
    }

    @Override
    public void refuel() {
        fuelLevel = 100;
        System.out.println("Fuel tank full.");
    }

    @Override
    public int getFuelLevel() {
        return fuelLevel;
    }
}