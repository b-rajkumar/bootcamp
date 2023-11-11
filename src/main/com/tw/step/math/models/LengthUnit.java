package com.tw.step.math.models;

public enum LengthUnit {
  FEET(12),
  INCH(1),
  CENTIMETER(0.3937),
  MILLIMETER(0.03937);

  private final double conversionFactor;

  LengthUnit(double conversionFactor) {
    this.conversionFactor = conversionFactor;
  }

  public double toStandard(double value) {
    return value * this.conversionFactor;
  }
}
