package com.tw.step.shapes;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RectangleTest {

  @Test
  void shouldCalculateTheArea() throws InvalidDimensionsException {
    Rectangle r = Rectangle.create(4, 2);

    assertEquals(8, r.area());
  }

  @Test
  void shouldThrowExceptionForNegativeLength() {
    InvalidDimensionsException exception = assertThrows(InvalidDimensionsException.class, () -> {
      Rectangle.create(-4, 2);
    });

    assertEquals(-4, exception.length);
  }

  @Test
  void shouldThrowExceptionForNegativeWidth() {
    InvalidDimensionsException exception = assertThrows(InvalidDimensionsException.class, () -> {
      Rectangle.create(4, -1);
    });

    assertEquals(-1, exception.width);
  }

}