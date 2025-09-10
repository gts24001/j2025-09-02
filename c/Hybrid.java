package c;

public class Hybrid implements ElectricVehicle, GasVehicle {

    private int batteryLevel;
    private int fuelLevel;
    private int milesTraveled;
    private double costPerKWh;
    private double costPerGallon;

    public Hybrid(int batteryLevel, int fuelLevel) {
        this.batteryLevel = batteryLevel;
        this.fuelLevel = fuelLevel;
    }

    // ----------------------------
    // General methods
    // ----------------------------
    public void setMilesTraveled(int miles) {
        this.milesTraveled = miles;
    }

    public int getMilesTraveled() {
        return milesTraveled;
    }

    // ----------------------------
    // GasVehicle implementation
    // ----------------------------
    @Override
    public void refuel() {
        fuelLevel = 100;
        System.out.println("Fuel tank full.");
    }

    @Override
    public int getFuelLevel() {
        return fuelLevel;
    }

    @Override
    public void setCostPerGallon(double cost) {
        this.costPerGallon = cost;
    }

    @Override
    public double getCostPerGallon() {
        return costPerGallon;
    }

    @Override
    public double calculateMPG(double miles, double gallonsUsed) {
        if (gallonsUsed <= 0) return 0.0;
        return miles / gallonsUsed;
    }

    // ----------------------------
    // ElectricVehicle implementation
    // ----------------------------
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
    public void setCostPerKWh(double cost) {
        this.costPerKWh = cost;
    }

    @Override
    public double getCostPerKWh() {
        return costPerKWh;
    }

    @Override
    public double calculateMPGe(double miles, double kWhUsed) {
        if (kWhUsed <= 0) return 0.0;
        return (miles / kWhUsed) * 33.7; // 33.7 kWh = 1 gallon equivalent
    }

    // ----------------------------
    // Hybrid-specific
    // ----------------------------
    public double calculateHybridAverage(double mpg, double mpge) {
        return (mpg + mpge) / 2.0;
    }
}
