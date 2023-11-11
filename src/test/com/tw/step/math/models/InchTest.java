package com.tw.step.math.models;

import com.tw.step.math.exceptions.InvalidMeasurementException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InchTest {
  @Test
  void shouldThrowExceptionForNegativeValues() {
    InvalidMeasurementException e = assertThrows(InvalidMeasurementException.class, () -> Inch.initiate(-1));
    assertEquals(e.value, -1);
  }

  @Test
  void shouldConvertToStandard() throws InvalidMeasurementException {
    Inch oneInch = Inch.initiate(1);
    MilliMeter twentyFiveMilliMeter = new MilliMeter(25.4);

    assertEquals(oneInch.toStandard(), twentyFiveMilliMeter);
  }
}