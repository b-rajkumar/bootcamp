package com.tw.step.parking_lot.exceptions;

public class ParkingLotFullException extends Throwable {
  public final int capacity;

  public ParkingLotFullException(int capacity) {
    super("Parking Lot is Full");
    this.capacity = capacity;
  }
}
