package com.tw.step.math.models;

public enum VolumeUnit {
  GALLON(3.78),
  LITER(1);

  private final double conversionFactor;

  VolumeUnit(double conversionFactor) {
    this.conversionFactor = conversionFactor;
  }

  public double toStandard(double value) {
    return value * this.conversionFactor;
  }
}
