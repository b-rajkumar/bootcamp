package com.tw.step.math.models;

import com.tw.step.math.measurements.exceptions.InvalidMeasurementException;
import com.tw.step.math.measurements.Length;
import com.tw.step.math.measurements.LengthUnit;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LengthTest {
  @Test
  void shouldThrowExceptionForNegativeValues() {
    InvalidMeasurementException e = assertThrows(InvalidMeasurementException.class, () -> Length.create(-1, LengthUnit.FEET));
    assertEquals(e.value, -1);
  }

  @Test
  void oneFeetShouldBeEqualToTwelveInches() throws InvalidMeasurementException {
    Length oneFeet = Length.create(1, LengthUnit.FEET);
    Length twelveInches = Length.create(12, LengthUnit.INCH);

    assertEquals(oneFeet, twelveInches);
  }

  @Test
  void twoInchesShouldBeEqualToFiveCentiMeters() throws InvalidMeasurementException {
    Length twoInches = Length.create(2, LengthUnit.INCH);
    Length fiveCentiMeters = Length.create(5, LengthUnit.CENTIMETER);

    assertEquals(twoInches, fiveCentiMeters);
  }


  @Test
  void shouldAddTwoLengths() throws InvalidMeasurementException {
    Length twoInches = Length.create(2, LengthUnit.INCH);
    Length fourInches = Length.create(4, LengthUnit.INCH);

    assertEquals(twoInches.add(twoInches), fourInches);
  }

  @Test
  void shouldAddTwoLengthsOfDifferentUnit() throws InvalidMeasurementException {
    Length twoInches = Length.create(2, LengthUnit.INCH);
    Length twoPointFiveCentimeters = Length.create(2.5, LengthUnit.CENTIMETER);
    Length threeInches = Length.create(3, LengthUnit.INCH);

    assertEquals(twoInches.add(twoPointFiveCentimeters), threeInches);
  }

}