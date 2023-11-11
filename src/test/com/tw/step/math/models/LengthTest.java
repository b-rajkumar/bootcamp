package com.tw.step.math.models;

import com.tw.step.math.exceptions.InvalidMeasurementException;
import com.tw.step.math.exceptions.TypeMismatchException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LengthTest {
  @Test
  void shouldThrowExceptionForNegativeValues() {
    InvalidMeasurementException e = assertThrows(InvalidMeasurementException.class, () -> Length.create(-1, LengthUnit.Feet));
    assertEquals(e.value, -1);
  }

  @Test
  void oneFeetShouldBeEqualToTwelveInches() throws InvalidMeasurementException {
    Length oneFeet = Length.create(1, LengthUnit.Feet);
    Length twelveInches = Length.create(12, LengthUnit.Inch);

    assertEquals(oneFeet, twelveInches);
  }


  @Test
  void twoInchesShouldBeEqualToFiveCentiMeters() throws InvalidMeasurementException {
    Length twoInches = Length.create(2, LengthUnit.Inch);
    Length fiveCentiMeters = Length.create(5, LengthUnit.CentiMeter);

    assertEquals(twoInches, fiveCentiMeters);
  }

  @Test
  void shouldThrowExceptionForDifferentTypesOfLength() throws InvalidMeasurementException {
    Length twoInches = Length.create(2, LengthUnit.Inch);
    Length fourCentimeters = Length.create(4, LengthUnit.CentiMeter);

    assertThrows(TypeMismatchException.class, () -> twoInches.add(fourCentimeters));
  }

  @Test
  void shouldAddTwoLengths() throws InvalidMeasurementException, TypeMismatchException {
    Length twoInches = Length.create(2, LengthUnit.Inch);
    Length fourInches = Length.create(4, LengthUnit.Inch);

    assertEquals(twoInches.add(twoInches), fourInches);
  }

}