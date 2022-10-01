package tm;

public class VehicleTM {
    private String vehicleNumber;
    private String vehicleType;
    private int parkingSlot;
    private String time;
    private String driverName;

    public VehicleTM(String vehicleNumber, String vehicleType, String driverName, String time) {
        this.vehicleNumber = vehicleNumber;
        this.vehicleType = vehicleType;
        this.driverName = driverName;
        this.time = time;
    }

    public VehicleTM(String vehicleNumber, String vehicleType, int parkingSlot, String time) {
        this.vehicleNumber = vehicleNumber;
        this.vehicleType = vehicleType;
        this.parkingSlot = parkingSlot;
        this.time = time;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public int getParkingSlot() {
        return parkingSlot;
    }

    public VehicleTM() {
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public void setParkingSlot(int parkingSlot) {
        this.parkingSlot = parkingSlot;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }
}
