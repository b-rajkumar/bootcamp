package com.tw.step.shapes;

public class InvalidDimensionsException extends Exception {
  public final int length;
  public final int width;

  public InvalidDimensionsException(int length, int width) {
    super("Dimensions can't be Negative");
    this.length = length;
    this.width = width;
  }
}
