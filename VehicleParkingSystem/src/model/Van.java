package model;

import tm.VehicleTM;

import static controller.FirstInterfaceFormController.*;

public class Van implements Vehicle {
    public static int[] reservedSlotsVan;

    static {
        reservedSlotsVan = new int[6];
        int x=1;
        for(int i=0; i<4; i++,x++){
            reservedSlotsVan[i]=x;
        }
        reservedSlotsVan[4]=12;
        reservedSlotsVan[5]=13;
    }

    public Van() {
    }

    public static int slotNoVan(String vehicleNo){
        int slotNoVan=0;
        boolean isPark=false;

        for (VehicleTM v : parkedTable) {
            if(v.getVehicleNumber().equals(vehicleNo)) {
                isPark = true;
                slotNoVan = v.getParkingSlot();
            }
        }
        if (!isPark) {
            for (int j = 0; j < reservedSlotsVan.length; j++) {
                if (parkingSlots[reservedSlotsVan[j] - 1] == null) {
                    slotNoVan = reservedSlotsVan[j];
                    break;
                }
            }
        }
        return slotNoVan;
    }

    @Override
    public void park(String vehicleNumber, String vehicleType) {
        managePark(vehicleNumber, vehicleType);
        parkingSlots[slotNo-1]="Not Available";
    }

    @Override
    public void leavePark(String vehicleNumber, String vehicleType) {
        int slotVan = manageLeavePark(vehicleNumber, vehicleType);
        parkingSlots[slotVan-1] = null;
    }

    public static int[] getReservedSlotsVan() {
        return reservedSlotsVan;
    }

    public static void setReservedSlotsVan(int[] reservedSlotsVan) {
        Van.reservedSlotsVan = reservedSlotsVan;
    }
}
