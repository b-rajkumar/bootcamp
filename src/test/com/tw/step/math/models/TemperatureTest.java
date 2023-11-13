package com.tw.step.math.models;

import com.tw.step.math.exceptions.InvalidMeasurementException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TemperatureTest {
  @Test
  void _212FShouldBeEqualTo100C() throws InvalidMeasurementException {
    Temperature _212F = Temperature.create(212, TemperatureUnit.FARENHEIT);
    Temperature _100C = Temperature.create(100, TemperatureUnit.CELCIUS);

    assertEquals(_212F, _100C);
  }
//
//  @Test
//  void shouldThrowExceptionForNegativeValues() {
//    InvalidMeasurementException e = assertThrows(InvalidMeasurementException.class, () -> Temperature.create(-1, TempratureUnit.GALLON);
//    assertEquals(e.value, -1);
//  }

}
