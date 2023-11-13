package com.tw.step.parking_lot;

import com.tw.step.parking_lot.exceptions.ParkingLotFullException;

public class Attendant {

  private final ParkingLot[] parkingLots;

  public Attendant(ParkingLot... parkingLots) {

    this.parkingLots = parkingLots;
  }

  public boolean park(Car car) {
    for (ParkingLot parkingLot : this.parkingLots) {
      try {
        parkingLot.park(car);
        return true;
      } catch (ParkingLotFullException e) {
      }
    }
    return false;
  }
}
