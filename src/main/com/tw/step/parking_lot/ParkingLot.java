package com.tw.step.parking_lot;

import com.tw.step.parking_lot.exceptions.ParkingLotFullException;

import java.util.ArrayList;

public class ParkingLot {

  private final int capacity;
  private final ArrayList<Car> slots;

  public ParkingLot(int capacity) {
    this.capacity = capacity;
    this.slots = new ArrayList<>(capacity);
  }

  public boolean park(Car car) throws ParkingLotFullException {
    if (this.isFull()) throw new ParkingLotFullException(capacity);
    return this.slots.add(car);
  }

  private boolean isFull() {
    return this.slots.size() == this.capacity;
  }
}
