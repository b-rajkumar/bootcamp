package com.tw.step.parking_lot;

import com.tw.step.parking_lot.exceptions.ParkingLotFullException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

public class AttendantTest {
  @Test
  void shouldParkACar() throws ParkingLotFullException {
    ParkingLot parkingLot = new ParkingLot(2);
    Attendant attendant = new Attendant();
    attendant.assignParkingLot(parkingLot);
    Car car = new Car();

    assertTrue(attendant.park(car));
  }

  @Test
  void shouldNotifyWhenTheParkingLotIsFull() throws ParkingLotFullException {
    ParkingLot parkingLot = new ParkingLot(1);
    Attendant attendant = new Attendant();
    Attendant spyAttendant = spy(attendant);
    Car car = new Car();

    spyAttendant.assignParkingLot(parkingLot);
    spyAttendant.park(car);

    verify(spyAttendant).park(car);
    verify(spyAttendant, times(1)).onFull(ParkingLotEvent.FULL, 1);
  }

  @Test
  void shouldNotParkIfParkingLotIsFull() throws ParkingLotFullException {
    ParkingLot parkingLot = new ParkingLot(1);
    Attendant attendant = new Attendant();
    Car car = new Car();

    attendant.assignParkingLot(parkingLot);
    attendant.park(car);

    assertFalse(attendant.park(car));
  }

  @Test
  void shouldHandleMultipleParkingLots() throws ParkingLotFullException {
    ParkingLot parkingLot1 = new ParkingLot(1);
    ParkingLot parkingLot2 = new ParkingLot(1);
    Attendant attendant = new Attendant();
    attendant.assignParkingLot(parkingLot1, parkingLot2);
    Car car = new Car();
    attendant.park(car);

    assertTrue(attendant.park(car));
  }

}
