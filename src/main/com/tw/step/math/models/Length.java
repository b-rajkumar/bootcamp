package com.tw.step.math.models;

import com.tw.step.math.exceptions.InvalidMeasurementException;

import java.util.Objects;

public class Length {
  private final double value;
  private final Unit unit;
  private static final Unit standardUnit = Unit.INCH;


  private Length(double value, Unit unit) {
    this.value = value;
    this.unit = unit;
  }

  public enum Unit {
    FEET(304.8),
    INCH(25.4),
    CENTIMETER(10),
    MILLIMETER(1);

    private final double conversionFactor;

    Unit(double conversionFactor) {
      this.conversionFactor = conversionFactor;
    }

    public Length toStandard(double value) {
      double conversionFactor = this.conversionFactor / Length.standardUnit.conversionFactor;

      return new Length(value * conversionFactor, Length.standardUnit);
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

    return Length.create(v1 + v2, Length.standardUnit);
  }

}
