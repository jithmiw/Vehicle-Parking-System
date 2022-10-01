package model;

import tm.VehicleTM;

import static controller.FirstInterfaceFormController.*;

public class Bus implements Vehicle{
    public static int[] reservedSlotsBus;

    static {
        reservedSlotsBus = new int[1];
        reservedSlotsBus[0]=14;
    }
    public Bus() {
    }

    public static int slotNoBus(String vehicleNo){
        int slotNoBus=0;
        boolean isPark=false;

        for (VehicleTM v : parkedTable) {
            if(v.getVehicleNumber().equals(vehicleNo)) {
                isPark = true;
                slotNoBus = v.getParkingSlot();
            }
        }
        if (!isPark) {
            for (int j = 0; j < reservedSlotsBus.length; j++) {
                if (parkingSlots[reservedSlotsBus[j] - 1] == null) {
                    slotNoBus = reservedSlotsBus[j];
                    break;
                }
            }
        }
        return slotNoBus;
    }
    @Override
    public void park(String vehicleNumber, String vehicleType) {
        managePark(vehicleNumber, vehicleType);
        parkingSlots[slotNo-1]="Not Available";
    }

    @Override
    public void leavePark(String vehicleNumber, String vehicleType) {
        int slotBus = manageLeavePark(vehicleNumber, vehicleType);
        parkingSlots[slotBus-1] = null;
    }

    public static int[] getReservedSlotsBus() {
        return reservedSlotsBus;
    }

    public static void setReservedSlotsBus(int[] reservedSlotsBus) {
        Bus.reservedSlotsBus = reservedSlotsBus;
    }
}
