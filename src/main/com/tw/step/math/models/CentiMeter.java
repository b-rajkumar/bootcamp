package com.tw.step.math.models;

import com.tw.step.math.exceptions.InvalidMeasurementException;

public class CentiMeter extends Length {
  private final double value;

  public CentiMeter(double value) {
    this.value = value;
  }

  public static CentiMeter initiate(int value) throws InvalidMeasurementException {
    if (value < 0) throw new InvalidMeasurementException(value);
    return new CentiMeter(value);
  }

  @Override
  MilliMeter toStandard() {
    return new MilliMeter(10 * this.value);
  }
}
