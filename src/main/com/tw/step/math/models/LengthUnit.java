package com.tw.step.math.models;

import com.tw.step.math.exceptions.InvalidMeasurementException;

public enum LengthUnit {
  Feet(304.8),
  Inch(25.4),
  CentiMeter(10),
  MilliMeter(1);

  private final double conversionFactor;

  LengthUnit(double conversionFactor) {
    this.conversionFactor = conversionFactor;
  }

  public double toStandard(double value) {
    return value * this.conversionFactor;
  }

}
