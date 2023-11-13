package com.tw.step.parking_lot;

import com.tw.step.parking_lot.exceptions.ParkingLotFullException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AttendantTest {
  @Test
  void shouldParkACar() throws ParkingLotFullException {
    ParkingLot parkingLot = new ParkingLot(1);
    Attendant attendant = Attendant.create(parkingLot);
    Car car = new Car();
    
    assertTrue(attendant.park(car));
  }

  @Test
  void shouldNotParkIfParkingLotIsFull() throws ParkingLotFullException {
    ParkingLot parkingLot = new ParkingLot(1);
    Attendant attendant = new Attendant(parkingLot);
    Car car = new Car();
    attendant.park(car);

    assertFalse(attendant.park(car));
  }

  @Test
  void shouldHandleMultipleParkingLots() throws ParkingLotFullException {
    ParkingLot parkingLot1 = new ParkingLot(1);
    ParkingLot parkingLot2 = new ParkingLot(1);
    Attendant attendant = new Attendant(parkingLot1, parkingLot2);
    Car car = new Car();
    attendant.park(car);

    assertTrue(attendant.park(car));
  }

}
