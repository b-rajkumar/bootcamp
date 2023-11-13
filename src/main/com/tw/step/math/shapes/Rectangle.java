package com.tw.step.math.shapes;

import com.tw.step.math.shapes.exceptions.InvalidDimensionsException;

public class Rectangle implements TwoDimensionalShape {
  private final double length;
  private final double width;

  private Rectangle(double length, double width) {
    this.length = length;
    this.width = width;
  }

  @Override
  public double area() {
    return this.length * this.width;
  }

  @Override
  public double perimeter() {
    return 2 * (this.length + this.width);
  }

  public boolean isSquare() {
    return this.length == this.width;
  }

  public static Rectangle create(double length, double width) throws InvalidDimensionsException {
    boolean isValidLength = length >= 0;
    boolean isValidWidth = width >= 0;

    if (isValidLength && isValidWidth) return new Rectangle(length, width);

    throw new InvalidDimensionsException(length, width);
  }

  public static Rectangle createSquare(double side) throws InvalidDimensionsException {
    return create(side, side);
  }
}
