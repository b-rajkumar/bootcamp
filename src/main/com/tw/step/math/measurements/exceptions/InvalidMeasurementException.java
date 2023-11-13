package com.tw.step.math.measurements.exceptions;

public class InvalidMeasurementException extends Exception {
  public final double value;

  public InvalidMeasurementException(double value) {
    super("Negative values not allowed");
    this.value = value;
  }
}
