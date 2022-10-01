package model;

public class Driver {
    public String driverName;
    public String nic;
    public String drivingLicenseNum;
    public String address;
    public int contactNum;

    public Driver() {
    }

    public Driver(String driverName, String nic, String drivingLicenseNum, String address, int contactNum) {
        this.driverName = driverName;
        this.nic = nic;
        this.drivingLicenseNum = drivingLicenseNum;
        this.address = address;
        this.contactNum = contactNum;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public String getDrivingLicenseNum() {
        return drivingLicenseNum;
    }

    public void setDrivingLicenseNum(String drivingLicenseNum) {
        this.drivingLicenseNum = drivingLicenseNum;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getContactNum() {
        return contactNum;
    }

    public void setContactNum(int contactNum) {
        this.contactNum = contactNum;
    }

    @Override
    public String toString() {
        return "Driver{" +
                "driverName='" + driverName + '\'' +
                ", nic='" + nic + '\'' +
                ", drivingLicenseNum='" + drivingLicenseNum + '\'' +
                ", address='" + address + '\'' +
                ", contactNum=" + contactNum +
                '}';
    }
}
