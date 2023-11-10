package com.tw.step.shapes.models;

import com.tw.step.shapes.exceptions.InvalidDimensionsException;

public class Square {
  private final double side;

  public static Square create(double side) throws InvalidDimensionsException {
    if (side >= 0) return new Square(side);

    throw new InvalidDimensionsException(side, side);
  }

  public Square(double side) {
    this.side = side;
  }

  public double area() {
    return this.side * this.side;
  }

  public double perimeter() {
    return 4 * this.side;
  }
}
