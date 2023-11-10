package com.tw.step.shapes;

import com.tw.step.shapes.models.Square;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SquareTest {
  @Test
  void shouldCalculateTheArea() {
    Square square = Square.create(2.5);

    assertEquals(6.25, square.area());
  }

  @Test
  void shouldCalculateThePerimeter() {
    Square square = Square.create(2.5);

    assertEquals(10.0, square.perimeter());
  }
}
