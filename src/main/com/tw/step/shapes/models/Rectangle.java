package com.tw.step.shapes.models;

import com.tw.step.shapes.exceptions.InvalidDimensionsException;
import com.tw.step.shapes.interfaces.TwoDimensionalShape;

public class Rectangle implements TwoDimensionalShape {
  private final double length;
  private final double width;

  Rectangle(double length, double width) {
    this.length = length;
    this.width = width;
  }

  public static Rectangle create(double length, double width) throws InvalidDimensionsException {
    boolean isValidLength = length >= 0;
    boolean isValidWidth = width >= 0;

    if (isValidLength && isValidWidth) return new Rectangle(length, width);

    throw new InvalidDimensionsException(length, width);
  }

  @Override
  public double area() {
    return this.length * this.width;
  }

  @Override
  public double perimeter() {
    return 2 * (this.length + this.width);
  }
}
