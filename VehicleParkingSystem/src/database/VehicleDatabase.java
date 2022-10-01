package database;

import java.util.ArrayList;

public class VehicleDatabase {
    public static ArrayList<tm.Vehicle> vehicleTable = new ArrayList<>();

    static {
        vehicleTable.add(new tm.Vehicle("NA-3434", "Bus", 3500, 60));
        vehicleTable.add(new tm.Vehicle("KA-4563", "Van", 1000, 7));
        vehicleTable.add(new tm.Vehicle("58-3567", "Van", 1500, 4));
        vehicleTable.add(new tm.Vehicle("GF-4358", "Van", 800, 4));
        vehicleTable.add(new tm.Vehicle("CCB-3568", "Van", 1800, 8));
        vehicleTable.add(new tm.Vehicle("LM-6679", "Van", 1500, 4));
        vehicleTable.add(new tm.Vehicle("QA-3369", "Van", 1800, 6));
        vehicleTable.add(new tm.Vehicle("KB-3668", "Cargo Lorry", 2500, 2));
        vehicleTable.add(new tm.Vehicle("JJ-9878", "Cargo Lorry", 3000, 2));
        vehicleTable.add(new tm.Vehicle("GH-5772", "Cargo Lorry", 4000, 3));
        vehicleTable.add(new tm.Vehicle("XY-4456", "Cargo Lorry", 3500, 2));
        vehicleTable.add(new tm.Vehicle("YQ-3536", "Cargo Lorry", 2000, 2));
        vehicleTable.add(new tm.Vehicle("CBB-3566", "Cargo Lorry", 2500, 2));
        vehicleTable.add(new tm.Vehicle("QH-3444", "Cargo Lorry", 5000, 4));
    }
}
