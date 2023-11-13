package com.tw.step.parking_lot;

import java.util.ArrayList;

public class ParkingLot {

  private final int capacity;
  private final ArrayList<Car> slots;

  public ParkingLot(int capacity) {
    this.capacity = capacity;
    this.slots = new ArrayList<>(capacity);
  }

  public boolean park(Car car) {
    if (this.isFull()) return false;
    return this.slots.add(car);
  }

  private boolean isFull() {
    return this.slots.size() == this.capacity;
  }
}
