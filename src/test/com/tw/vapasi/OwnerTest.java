package com.tw.vapasi;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class OwnerTest {
    @Test
    public void shouldNotifyOwnerWhenParkingIsFul() throws ParkingFullException {
        Owner owner = mock (Owner.class);

        ParkingLot parkingLot = new ParkingLot(1,owner);
        parkingLot.park(new Vehicles());

        verify(owner).notifyWhenParkingIsFull();
    }

    @Test
    public void shouldNotifyOwnerWhenParkingIsAvailable() throws Exception {
        Owner owner = mock (Owner.class);

        ParkingLot parkingLot = new ParkingLot(2,owner);

        Vehicles vehicle1 = new Vehicles();
        parkingLot.park(vehicle1);

        Vehicles vehicle2 = new Vehicles();
        parkingLot.park(vehicle2);

        parkingLot.unPark(vehicle1);

        verify(owner).notifyWhenParkingIsAvailable();
    }
}