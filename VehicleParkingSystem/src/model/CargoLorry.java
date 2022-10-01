package model;

import tm.VehicleTM;

import static controller.FirstInterfaceFormController.*;

public class CargoLorry implements Vehicle{
    public static int[] reservedSlotsLorry;

    static {
        reservedSlotsLorry = new int[7];
        int x=5;
        for(int i=0;i<reservedSlotsLorry.length; i++,x++){
            reservedSlotsLorry[i]=x;
        }
    }

    public CargoLorry() {
    }

    public static int slotNoLorry(String vehicleNo){
        int slotNoLorry=0;
        boolean isPark=false;

        for (VehicleTM v : parkedTable) {
            if(v.getVehicleNumber().equals(vehicleNo)) {
                isPark = true;
                slotNoLorry = v.getParkingSlot();
            }
        }
        if (!isPark) {
            for (int j = 0; j < reservedSlotsLorry.length; j++) {
                if (parkingSlots[reservedSlotsLorry[j] - 1] == null) {
                    slotNoLorry = reservedSlotsLorry[j];
                    break;
                }
            }
        }
        return slotNoLorry;
    }

    @Override
    public void park(String vehicleNumber, String vehicleType) {
        managePark(vehicleNumber, vehicleType);
        parkingSlots[slotNo-1]="Not Available";
    }

    @Override
    public void leavePark(String vehicleNumber, String vehicleType) {
        int slotLorry = manageLeavePark(vehicleNumber, vehicleType);
        parkingSlots[slotLorry-1] = null;
    }

    public static int[] getReservedSlotsLorry() {
        return reservedSlotsLorry;
    }

    public static void setReservedSlotsLorry(int[] reservedSlotsLorry) {
        CargoLorry.reservedSlotsLorry = reservedSlotsLorry;
    }
}
