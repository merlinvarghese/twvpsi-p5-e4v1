package com.tw.vapasi;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ParkingLotTest {

    @Test
    void expectVehicleIsParked() {
        ParkingLot parkingLot = new ParkingLot(1);
        assertDoesNotThrow(() -> parkingLot.park(new Vehicles("KA-05-1111")));
    }

    @Test
    void expectVehcleIsUnParked() throws ParkingException {
        ParkingLot parkingLot = new ParkingLot(1);
        parkingLot.park(new Vehicles("KA-05-1111"));
        assertDoesNotThrow(() -> parkingLot.unPark(new Vehicles("KA-05-1111")));
    }

    @Test
    void expectFailsIfSlotNotAvailable() throws ParkingException {
        ParkingLot parkingLot = new ParkingLot(0);
        assertThrows(ParkingFullException.class, () -> parkingLot.park(new Vehicles("KA-05-1111")));
    }

    @Test
    void expectFailUnParkIfVehicleNotParked() throws ParkingException {
        ParkingLot parkingLot = new ParkingLot(0);
        assertThrows(VehicleUnparkedException.class, () -> parkingLot.unPark(new Vehicles("KA-05-1111")));
    }

    @Test
    void expectSuccessIsParked() throws ParkingException {
        ParkingLot parkingLot = new ParkingLot(1);
        parkingLot.park(new Vehicles("KA-05-1111"));
        assertDoesNotThrow(() -> parkingLot.isParked(new Vehicles("KA-05-1111")));
    }

    @Test
    void expectFailIsNotParked() throws ParkingException {
        ParkingLot parkingLot = new ParkingLot(1);
        parkingLot.park(new Vehicles("KA-05-1111"));
        assertThrows(VehicleNotParkedException.class,() -> parkingLot.isParked(new Vehicles("KA-05-1112")));
    }

}
