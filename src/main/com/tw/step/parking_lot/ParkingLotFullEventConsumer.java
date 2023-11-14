package com.tw.step.parking_lot;

public interface ParkingLotFullEventConsumer extends EventConsumer {
  void onFull(ParkingLotEvent event, int parkingLotId);
}
