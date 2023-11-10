package com.tw.step.shapes.exceptions;

public class InvalidDimensionsException extends Exception {
  public final double length;
  public final double width;

  public InvalidDimensionsException(double length, double width) {
    super("Dimensions can't be Negative");
    this.length = length;
    this.width = width;
  }
}
