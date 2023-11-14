package com.tw.step.parking_lot;

import com.tw.step.parking_lot.exceptions.ParkingLotFullException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ParkingLot {

  private final int capacity;
  private final ArrayList<Car> slots;
  private final HashMap<ParkingLotEvent, List<EventConsumer>> events = new HashMap<>();

  public ParkingLot(int capacity) {
    this.capacity = capacity;
    this.slots = new ArrayList<>(capacity);
  }

  public boolean park(Car car) throws ParkingLotFullException {
    if (this.isFull()) throw new ParkingLotFullException(this.capacity);
    this.slots.add(car);

    if (this.isFull() && this.events.containsKey(ParkingLotEvent.FULL))
      publishFullEvent();

    return true;
  }

  private void publishFullEvent() {
    List<EventConsumer> eventConsumers = this.events.get(ParkingLotEvent.FULL);
    for (EventConsumer eventConsumer : eventConsumers) {
      ParkingLotFullEventConsumer consumer = (ParkingLotFullEventConsumer) eventConsumer;
      consumer.onFull(ParkingLotEvent.FULL, 1);
    }
  }

  public boolean isFull() {
    return this.slots.size() == this.capacity;
  }

  public void addFullEventListener(ParkingLotFullEventConsumer consumer) {
    this.events.putIfAbsent(ParkingLotEvent.FULL, new ArrayList<>());
    List<EventConsumer> eventConsumers = this.events.get(ParkingLotEvent.FULL);
    eventConsumers.add(consumer);
  }
}
