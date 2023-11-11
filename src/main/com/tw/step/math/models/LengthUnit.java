package com.tw.step.math.models;

public enum LengthUnit {
  FEET(304.8),
  INCH(25.4),
  CENTIMETER(10),
  MILLIMETER(1);

  private final double conversionFactor;

  LengthUnit(double conversionFactor) {
    this.conversionFactor = conversionFactor;
  }

  public double toStandard(double value) {
    return value * this.conversionFactor;
  }
}
