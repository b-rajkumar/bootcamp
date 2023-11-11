package com.tw.step.math.exceptions;

public class InvalidMeasurementException extends Exception {
  public final int value;

  public InvalidMeasurementException(int value) {
    super("Negative values not allowed");
    this.value = value;
  }
}
