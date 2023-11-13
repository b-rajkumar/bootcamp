package com.tw.step.math.measurements;

public enum LengthUnit {
  FEET(304.8),
  INCH(25.4),
  CENTIMETER(10),
  MILLIMETER(1);

  private final double conversionFactor;

  LengthUnit(double conversionFactor) {
    this.conversionFactor = conversionFactor;
  }

  public LengthUnit getStandard() {
    return INCH;
  }

  public double toStandard(double value) {
    LengthUnit standardUnit = this.getStandard();
    double conversionFactor = this.conversionFactor / standardUnit.conversionFactor;

    return value * conversionFactor;
  }
}
