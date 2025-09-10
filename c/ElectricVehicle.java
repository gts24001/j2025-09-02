package c;

public interface ElectricVehicle {
    // Battery handling
    void chargeBattery();
    int getBatteryLevel();

    // Energy cost
    void setCostPerKWh(double cost);
    double getCostPerKWh();

    // Efficiency calculation
    double calculateMPGe(double miles, double kWhUsed);
}