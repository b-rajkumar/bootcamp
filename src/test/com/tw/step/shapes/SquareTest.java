package com.tw.step.shapes;

import com.tw.step.shapes.exceptions.InvalidDimensionsException;
import com.tw.step.shapes.models.Square;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SquareTest {
  @Test
  void shouldCalculateTheArea() throws InvalidDimensionsException {
    Square square = Square.create(2.5);

    assertEquals(6.25, square.area());
  }

  @Test
  void shouldCalculateThePerimeter() throws InvalidDimensionsException {
    Square square = Square.create(2.5);

    assertEquals(10.0, square.perimeter());
  }

  @Test
  void shouldThrowExceptionForNegativeSide() {
    InvalidDimensionsException exception = assertThrows(InvalidDimensionsException.class, () -> Square.create(-4));

    assertEquals(-4, exception.length);
  }

}
