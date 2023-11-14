package com.tw.step.parking_lot;

import com.tw.step.parking_lot.exceptions.ParkingLotFullException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Attendant implements ParkingLotFullEventConsumer {
  private final List<ParkingLot> parkingLots = new ArrayList<>();

  public boolean park(Car car) throws ParkingLotFullException {

    Optional<ParkingLot> parkingLot = getParkableLot();
    boolean isParked = false;
    if (parkingLot.isPresent()) {
      isParked = parkingLot.get().park(car);
    }

    return isParked;
  }

  private Optional<ParkingLot> getParkableLot() {
    return this.parkingLots.stream().filter(a -> !a.isFull()).findFirst();
  }

  public void assignParkingLot(ParkingLot... parkingLots) {
    for (ParkingLot parkingLot : parkingLots) {
      parkingLot.addFullEventListener(this);
      this.parkingLots.add(parkingLot);
    }
  }

  @Override
  public void onFull(ParkingLotEvent event, int parkingLotId) {
    System.out.println("Parking Lot is full");
  }
}
