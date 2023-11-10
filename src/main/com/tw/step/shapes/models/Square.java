package com.tw.step.shapes.models;

import com.tw.step.shapes.exceptions.InvalidDimensionsException;

public class Square extends Rectangle {

  private Square(double side) {
    super(side, side);
  }

  public static Square create(double side) throws InvalidDimensionsException {
    if (side >= 0) return new Square(side);

    throw new InvalidDimensionsException(side, side);
  }
}
