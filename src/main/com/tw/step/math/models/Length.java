package com.tw.step.math.models;

import com.tw.step.math.exceptions.InvalidMeasurementException;
import com.tw.step.math.exceptions.TypeMismatchException;

import java.util.Objects;

public class Length {
  private final double value;
  private final LengthUnit unit;

  private Length(double value, LengthUnit unit) {
    this.value = value;
    this.unit = unit;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Length length = (Length) o;

    double v1 = this.unit.toStandard(this.value);
    double v2 = length.unit.toStandard(length.value);

    return Math.abs(v1 - v2) < 1;
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.value, this.unit);
  }

  public static Length create(double value, LengthUnit lengthUnit) throws InvalidMeasurementException {
    if (value < 0) throw new InvalidMeasurementException(value);

    return new Length(value, lengthUnit);
  }

  public Length add(Length length) throws InvalidMeasurementException, TypeMismatchException {
    if (this.unit != length.unit)
      throw new TypeMismatchException(this.unit, length.unit);
    return Length.create(this.value + length.value, this.unit);
  }
}
