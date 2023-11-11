package com.tw.step.math.models;

import com.tw.step.math.exceptions.InvalidMeasurementException;
import com.tw.step.math.exceptions.TypeMismatchException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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
  void shouldThrowExceptionForDifferentTypesOfLength() throws InvalidMeasurementException {
    Length twoInches = Length.create(2, LengthUnit.INCH);
    Length fourMilliMeter = Length.create(4, LengthUnit.MILLIMETER);

    TypeMismatchException e = assertThrows(TypeMismatchException.class, () -> twoInches.add(fourMilliMeter));
    assertEquals(e.firstUnit, LengthUnit.INCH);
    assertEquals(e.secondUnit, LengthUnit.MILLIMETER);
  }

  @Test
  void shouldAddTwoLengths() throws InvalidMeasurementException, TypeMismatchException {
    Length twoInches = Length.create(2, LengthUnit.INCH);
    Length fourInches = Length.create(4, LengthUnit.INCH);

    assertEquals(twoInches.add(twoInches), fourInches);
  }

}