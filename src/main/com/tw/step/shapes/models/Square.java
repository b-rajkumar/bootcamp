package com.tw.step.shapes.models;

public class Square {
  private final double side;

  public static Square create(double side) {
    return new Square(side);
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
