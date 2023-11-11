package com.tw.step.math.models;

import com.tw.step.math.exceptions.InvalidMeasurementException;

public class Feet extends Length {
  private final double value;

  public Feet(double value) {
    this.value = value;
  }

  public static Feet initiate(int value) throws InvalidMeasurementException {
    if (value < 0) throw new InvalidMeasurementException(value);
    return new Feet(value);
  }

  @Override
  MilliMeter toStandard() {
    return new MilliMeter(304.8 * this.value);
  }
}