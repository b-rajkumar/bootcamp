package com.tw.step.shapes;

import com.tw.step.shapes.exceptions.InvalidDimensionsException;
import com.tw.step.shapes.models.Rectangle;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RectangleTest {

  @Test
  void shouldCalculateTheArea() throws InvalidDimensionsException {
    Rectangle r = Rectangle.create(4.1, 2.2);

    assertEquals(9.02, r.area());
  }

  @Test
  void shouldThrowExceptionForNegativeLength() {
    InvalidDimensionsException exception = assertThrows(InvalidDimensionsException.class, () -> Rectangle.create(-4, 2));
    
    assertEquals(-4, exception.length);
  }

  @Test
  void shouldThrowExceptionForNegativeWidth() {
    InvalidDimensionsException exception = assertThrows(InvalidDimensionsException.class, () -> Rectangle.create(4, -1));

    assertEquals(-1, exception.width);
  }

  @Test
  void shouldCalculateThePerimeter() throws InvalidDimensionsException {
    Rectangle r = Rectangle.create(4, 2);

    assertEquals(12, r.perimeter());
  }

}