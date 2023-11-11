package com.tw.step.math.models;

import com.tw.step.math.exceptions.InvalidMeasurementException;

import java.util.Objects;

public class Length {
  private final double value;
  private final Unit unit;

  private Length(double value, Unit unit) {
    this.value = value;
    this.unit = unit;
  }

  public enum Unit {
    FEET(12),
    INCH(1),
    CENTIMETER(0.3937),
    MILLIMETER(0.03937);

    private final double conversionFactor;

    Unit(double conversionFactor) {
      this.conversionFactor = conversionFactor;
    }

    public Length toStandard(double value) {
      return new Length(value * this.conversionFactor, this.INCH);
    }
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Length length = (Length) o;

    double v1 = this.unit.toStandard(this.value).value;
    double v2 = length.unit.toStandard(length.value).value;

    return Math.abs(v1 - v2) < 0.1;
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.value, this.unit);
  }

  public static Length create(double value, Unit lengthUnit) throws InvalidMeasurementException {
    if (value < 0) throw new InvalidMeasurementException(value);

    return new Length(value, lengthUnit);
  }

  public Length add(Length length) throws InvalidMeasurementException {
    double v1 = this.unit.toStandard(this.value).value;
    double v2 = length.unit.toStandard(length.value).value;

    return Length.create(v1 + v2, Unit.INCH);
  }

}
