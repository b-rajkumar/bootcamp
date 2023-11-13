package com.tw.step.parking_lot;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParkingLotTest {

  @Test
  void shouldBeTrueIfTheCarIsParked() {
    ParkingLot parkingLot = new ParkingLot(2);

    assertTrue(parkingLot.park(new Car()));
  }

  @Test
  void shouldBeFalseIfTheParkingLotIsFull() {
    ParkingLot parkingLot = new ParkingLot(1);
    parkingLot.park(new Car());

    assertFalse(parkingLot.park(new Car()));
  }
}