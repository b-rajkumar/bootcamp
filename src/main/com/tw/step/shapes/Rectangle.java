package com.tw.step.shapes;

public class Rectangle {
  private final double length;
  private final double width;

  private Rectangle(double length, double width) {
    this.length = length;
    this.width = width;
  }

  public static Rectangle create(double length, double width) throws InvalidDimensionsException {
    boolean isValidLength = length >= 0;
    boolean isValidWidth = width >= 0;

    if (isValidLength && isValidWidth) return new Rectangle(length, width);

    throw new InvalidDimensionsException(length, width);
  }

  public double area() {
    return this.length * this.width;
  }

  public double perimeter() {
    return 2 * (this.length + this.width);
  }
}
