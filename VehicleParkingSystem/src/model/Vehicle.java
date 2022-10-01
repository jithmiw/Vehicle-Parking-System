package model;

public interface Vehicle {
    String vehicleNumber = null;
    String vehicleType = null;
    int maximumWeight = 0;
    int numberOfPassengers = 0;
    String driverNIC = null;

    void park(String vehicleNumber,String vehicleType);
    void leavePark(String vehicleNumber,String vehicleType);
}
