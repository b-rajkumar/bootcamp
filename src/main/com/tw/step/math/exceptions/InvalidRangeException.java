package com.tw.step.math.exceptions;

public class InvalidRangeException extends Throwable {
  public final double value;

  public InvalidRangeException(double value) {
    super("Invalid Range");
    this.value = value;
  }
}
