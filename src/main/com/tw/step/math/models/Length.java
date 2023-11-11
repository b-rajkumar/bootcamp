package com.tw.step.math.models;

import com.tw.step.math.exceptions.InvalidMeasurementException;
import com.tw.step.math.exceptions.TypeMismatchException;

import java.util.Objects;

public class Length {
  private final double value;
  private final LengthUnit lengthUnit;

  private Length(double value, LengthUnit lengthUnit) {
    this.value = value;
    this.lengthUnit = lengthUnit;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Length length = (Length) o;

    double v1 = this.lengthUnit.toStandard(this.value);
    double v2 = length.lengthUnit.toStandard(length.value);

    return Math.abs(v1 - v2) < 1;
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.value, this.lengthUnit);
  }

  public static Length create(double value, LengthUnit lengthUnit) throws InvalidMeasurementException {
    if (value < 0) throw new InvalidMeasurementException(value);

    return new Length(value, lengthUnit);
  }

  public Length add(Length length) throws InvalidMeasurementException, TypeMismatchException {
    if (this.lengthUnit != length.lengthUnit) throw new TypeMismatchException();
    return Length.create(this.value + length.value, this.lengthUnit);
  }
}
