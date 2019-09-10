package com.tw.vapasi;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
    private final int noOfSlots;
    private List<String> vehicles;
    private Owner owner;

    ParkingLot(int noOfSlots) {
        this.noOfSlots = noOfSlots;
        vehicles = new ArrayList<>();
    }

    ParkingLot(int noOfSlots, Owner owner) {
        this.noOfSlots = noOfSlots;
        vehicles = new ArrayList<>();
        this.owner = owner;
    }

    void park(Vehicles vehicle) throws ParkingFullException{

        if (isSlotNotAvailable()) {
            throw new ParkingFullException(" Parking Full");
        }
        vehicles.add(vehicle.registrationNumber);
        if(isSlotNotAvailable()){
            owner.notifyWhenParkingIsFull();
        }

    }

    void unPark(Vehicles vehicle) throws VehicleUnparkedException {
        if (!isParked(vehicle)) {
            throw new VehicleUnparkedException("Vehicle Can not be Unparked");
        }
        vehicles.remove(vehicle.registrationNumber);

    }

     boolean isParked(Vehicles vehicle)  {
        return vehicles.contains(vehicle.registrationNumber);
    }

    private boolean isSlotNotAvailable() {
        return vehicles.size() == noOfSlots;
    }
}
