package com.tw.step.math.models;

import com.tw.step.math.shapes.exceptions.InvalidDimensionsException;
import com.tw.step.math.shapes.Rectangle;
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

  @Test
  void shouldCalculateTheSquareArea() throws InvalidDimensionsException {
    Rectangle square = Rectangle.createSquare(2.5);

    assertEquals(6.25, square.area());
  }

  @Test
  void shouldCalculateTheSquarePerimeter() throws InvalidDimensionsException {
    Rectangle square = Rectangle.createSquare(2.5);

    assertEquals(10.0, square.perimeter());
  }

  @Test
  void shouldBeASquare() throws InvalidDimensionsException {
    Rectangle square = Rectangle.createSquare(2.5);
    assertTrue(square.isSquare());
  }

  @Test
  void shouldNotBeASquare() throws InvalidDimensionsException {
    Rectangle r = Rectangle.create(4, 2);
    assertTrue(!r.isSquare());
  }
}