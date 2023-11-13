package com.tw.step.parking_lot;

import com.tw.step.parking_lot.exceptions.ParkingLotFullException;

import java.util.List;
import java.util.Optional;

public class Attendant {
  private final List<ParkingLot> parkingLots;

  public Attendant(ParkingLot... parkingLots) {
    this.parkingLots = List.of(parkingLots);
  }

  public static Attendant create(ParkingLot... parkingLots) {
    Attendant attendant = new Attendant(parkingLots);
    for (ParkingLot parkingLot : parkingLots) {
      parkingLot.on("full", attendant::lotFull);
    }

    return attendant;
  }

  private void lotFull(ParkingLot parkingLot) {
    System.out.println("Lot is full");
  }

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
}
