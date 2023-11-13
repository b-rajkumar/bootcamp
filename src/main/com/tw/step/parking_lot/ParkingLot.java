package com.tw.step.parking_lot;

import com.tw.step.parking_lot.exceptions.ParkingLotFullException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.function.Consumer;

public class ParkingLot {

  private final int capacity;
  private final ArrayList<Car> slots;
  private final HashMap<String, List<Consumer<ParkingLot>>> events = new HashMap<>();

  public ParkingLot(int capacity) {
    this.capacity = capacity;
    this.slots = new ArrayList<>(capacity);
  }

  public boolean park(Car car) throws ParkingLotFullException {
    if (this.isFull()) throw new ParkingLotFullException(this.capacity);
    this.slots.add(car);

    boolean areFullHandlersPresent = this.events.get("full") != null;
    if (this.isFull() && areFullHandlersPresent) {
      for (Consumer<ParkingLot> handler : this.events.get("full")) {
        handler.accept(this);
      }
    }

    return true;
  }

  public boolean isFull() {
    return this.slots.size() == this.capacity;
  }

  public void on(String event, Consumer<ParkingLot> handler) {
    this.events.putIfAbsent(event, new ArrayList<>());
    List<Consumer<ParkingLot>> handlers = this.events.get(event);
    handlers.add(handler);
  }
}
