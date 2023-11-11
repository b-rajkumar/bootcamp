package com.tw.step.math.models;

import com.tw.step.math.exceptions.InvalidMeasurementException;

public class Inch extends Length {
  private final double value;

  public Inch(double value) {
    this.value = value;
  }

  public static Inch initiate(int value) throws InvalidMeasurementException {
    if (value < 0) throw new InvalidMeasurementException(value);
    return new Inch(value);
  }

  @Override
  MilliMeter toStandard() {
    return new MilliMeter(25.4 * this.value);
  }
}
