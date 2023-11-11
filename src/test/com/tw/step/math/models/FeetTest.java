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
  void shouldConvertToStandard() throws InvalidMeasurementException {
    Feet oneFeet = Feet.initiate(1);
    MilliMeter threeHundredFour = new MilliMeter(304.8);

    assertEquals(oneFeet.toStandard(), threeHundredFour);
  }

  @Test
  void oneFeetShouldBeEqualToTwelveInches() throws InvalidMeasurementException {
    Feet oneFeet = Feet.initiate(1);
    Inch twelveInches = Inch.initiate(12);

    assertTrue(oneFeet.isEqual(twelveInches));
  }
}