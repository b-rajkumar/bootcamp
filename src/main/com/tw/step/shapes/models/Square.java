package com.tw.step.shapes.models;

import com.tw.step.shapes.exceptions.InvalidDimensionsException;
import com.tw.step.shapes.interfaces.TwoDimensionalShape;

public class Square implements TwoDimensionalShape {
  private final double side;

  private Square(double side) {
    this.side = side;
  }

  @Override
  public double area() {
    return this.side * this.side;
  }

  @Override
  public double perimeter() {
    return 4 * this.side;
  }

  public static Square create(double side) throws InvalidDimensionsException {
    if (side >= 0) return new Square(side);

    throw new InvalidDimensionsException(side, side);
  }
}
