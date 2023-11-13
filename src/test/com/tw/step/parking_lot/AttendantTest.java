package com.tw.step.parking_lot;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AttendantTest {
  @Test
  void shouldParkACar() {
    ParkingLot parkingLot = new ParkingLot(1);
    Attendant attendant = new Attendant(parkingLot);
    Car car = new Car();

    assertTrue(attendant.park(car));
  }

  @Test
  void shouldNotParkIfParkingLotIsFull() {
    ParkingLot parkingLot = new ParkingLot(1);
    Attendant attendant = new Attendant(parkingLot);
    Car car = new Car();
    attendant.park(car);

    assertFalse(attendant.park(car));
  }

  @Test
  void shouldHandleMultipleParkingLots() {
    ParkingLot parkingLot1 = new ParkingLot(1);
    ParkingLot parkingLot2 = new ParkingLot(1);
    Attendant attendant = new Attendant(parkingLot1, parkingLot2);
    Car car = new Car();
    attendant.park(car);

    assertTrue(attendant.park(car));
  }
  
}
