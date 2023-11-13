package com.tw.step.parking_lot;

import com.tw.step.parking_lot.exceptions.ParkingLotFullException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParkingLotTest {

  @Test
  void shouldParkTheCar() throws ParkingLotFullException {
    ParkingLot parkingLot = new ParkingLot(2);

    assertTrue(parkingLot.park(new Car()));
  }

  @Test
  void shouldThrowExceptionWhenParkingLotIsFull() throws ParkingLotFullException {
    ParkingLot parkingLot = new ParkingLot(1);
    parkingLot.park(new Car());

    ParkingLotFullException e = assertThrows(ParkingLotFullException.class, () -> parkingLot.park(new Car()));
    assertEquals(e.capacity, 1);
  }
}