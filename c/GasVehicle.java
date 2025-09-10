package c;

public interface GasVehicle {
    // Fuel handling
    void refuel();
    int getFuelLevel();

    // Energy cost
    void setCostPerGallon(double cost);
    double getCostPerGallon();

    // Efficiency calculation
    double calculateMPG(double miles, double gallonsUsed);
}