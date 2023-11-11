package com.tw.step.math.models;

import com.tw.step.math.exceptions.InvalidMeasurementException;

public class Feet {

  private final int value;

  public Feet(int value) {
    this.value = value;
  }


  public static Feet initiate(int value) throws InvalidMeasurementException {
    if (value < 0) throw new InvalidMeasurementException(value);

    return new Feet(value);
  }

  public Inch toInches() {
    return new Inch(12 * this.value);
  }
}
