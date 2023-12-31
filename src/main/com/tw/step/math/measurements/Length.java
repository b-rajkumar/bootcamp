package com.tw.step.math.measurements;

import com.tw.step.math.measurements.exceptions.InvalidMeasurementException;

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

    return Math.abs(v1 - v2) < 0.1;
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.value, this.unit);
  }

  public static Length create(double value, LengthUnit lengthUnit) throws InvalidMeasurementException {
    if (value < 0) throw new InvalidMeasurementException(value);

    return new Length(value, lengthUnit);
  }

  public Length add(Length length) throws InvalidMeasurementException {
    double v1 = this.unit.toStandard(this.value);
    double v2 = length.unit.toStandard(length.value);

    return Length.create(v1 + v2, this.unit.getStandard());
  }

}
