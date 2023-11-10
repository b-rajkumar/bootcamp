package com.tw.step.math.exceptions;

public class InvalidRange extends Throwable {
  public final double value;

  public InvalidRange(double value) {
    super("Invalid Range");
    this.value = value;
  }
}
