package com.tw.step.math.measurements;

public enum TemperatureUnit {
  CELCIUS(1.8, 32), FARENHEIT(1, 0);

  private final double gradient;
  private final double constant;

  TemperatureUnit(double gradient, double constant) {
    this.gradient = gradient;
    this.constant = constant;
  }

  public TemperatureUnit getStandard() {
    return FARENHEIT;
  }

  public double toStandard(double value) {
    return gradient * value + constant;
  }
}
