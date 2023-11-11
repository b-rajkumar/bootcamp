package com.tw.step.math.models;

import com.tw.step.math.exceptions.InvalidMeasurementException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FeetTest {
  @Test
  void shouldThrowExceptionForNegativeValues() {
    InvalidMeasurementException e = assertThrows(InvalidMeasurementException.class, () -> Feet.initiate(-1));
    assertEquals(e.value, -1);
  }

  @Test
  void shouldConvertToInches() throws InvalidMeasurementException {
    Feet oneFeet = Feet.initiate(1);
    Inch twelveInches = new Inch(12);
    Inch oneFeetInInches = oneFeet.toInches();

    assertEquals(oneFeetInInches, twelveInches);
  }
}