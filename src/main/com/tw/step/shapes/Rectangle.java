package com.tw.step.shapes;

public class Rectangle {
  private final int length;
  private final int width;

  public Rectangle(int length, int width) {
    this.length = length;
    this.width = width;
  }

  public static void main(String[] args) {
    System.out.println("hello");
  }

  public int area() {
    return this.length * this.width;
  }
}
