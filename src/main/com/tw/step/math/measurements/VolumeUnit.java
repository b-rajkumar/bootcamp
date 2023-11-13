package com.tw.step.math.measurements;

public enum VolumeUnit {
  GALLON(3.78),
  LITER(1);

  private final double conversionFactor;

  VolumeUnit(double conversionFactor) {
    this.conversionFactor = conversionFactor;
  }

  public VolumeUnit getStandard() {
    return LITER;
  }

  public double toStandard(double value) {
    VolumeUnit standardUnit = this.getStandard();
    double conversionFactor = this.conversionFactor / standardUnit.conversionFactor;

    return value * conversionFactor;
  }
}
