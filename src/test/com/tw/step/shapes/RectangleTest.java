package com.tw.step.shapes;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RectangleTest {

  @Test
  void shouldGetTheArea() {
    Rectangle r = Rectangle.create(4, 2);

    assertEquals(8, r.area());
  }
}