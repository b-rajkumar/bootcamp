package com.tw.step.math.models;

import com.tw.step.math.exceptions.InvalidMeasurementException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CentiMeterTest {
  @Test
  void shouldThrowExceptionForNegativeValues() {
    InvalidMeasurementException e = assertThrows(InvalidMeasurementException.class, () -> CentiMeter.initiate(-1));
    assertEquals(e.value, -1);
  }

  @Test
  void shouldConvertToStandard() throws InvalidMeasurementException {
    CentiMeter oneCentimeter = CentiMeter.initiate(1);
    MilliMeter tenMilliMeter = new MilliMeter(10);

    assertEquals(oneCentimeter.toStandard(), tenMilliMeter);
  }
}