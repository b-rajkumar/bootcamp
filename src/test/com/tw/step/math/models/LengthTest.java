package com.tw.step.math.models;

import com.tw.step.math.exceptions.InvalidMeasurementException;
import com.tw.step.math.exceptions.TypeMismatchException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LengthTest {
  @Test
  void shouldThrowExceptionForNegativeValues() {
    InvalidMeasurementException e = assertThrows(InvalidMeasurementException.class, () -> Length.create(-1, Length.Unit.FEET));
    assertEquals(e.value, -1);
  }

  @Test
  void oneFeetShouldBeEqualToTwelveInches() throws InvalidMeasurementException {
    Length oneFeet = Length.create(1, Length.Unit.FEET);
    Length twelveInches = Length.create(12, Length.Unit.INCH);

    assertEquals(oneFeet, twelveInches);
  }

  @Test
  void twoInchesShouldBeEqualToFiveCentiMeters() throws InvalidMeasurementException {
    Length twoInches = Length.create(2, Length.Unit.INCH);
    Length fiveCentiMeters = Length.create(5, Length.Unit.CENTIMETER);

    assertEquals(twoInches, fiveCentiMeters);
  }


  @Test
  void shouldAddTwoLengths() throws InvalidMeasurementException {
    Length twoInches = Length.create(2, Length.Unit.INCH);
    Length fourInches = Length.create(4, Length.Unit.INCH);

    assertEquals(twoInches.add(twoInches), fourInches);
  }

  @Test
  void shouldAddTwoLengthsOfDifferentUnit() throws InvalidMeasurementException {
    Length twoInches = Length.create(2, Length.Unit.INCH);
    Length twoPointFiveCentimeters = Length.create(2.5, Length.Unit.CENTIMETER);
    Length threeInches = Length.create(3, Length.Unit.INCH);

    assertEquals(twoInches.add(twoPointFiveCentimeters), threeInches);
  }

}