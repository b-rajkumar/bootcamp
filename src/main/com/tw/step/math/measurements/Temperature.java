package com.tw.step.math.measurements;

import com.tw.step.math.measurements.exceptions.InvalidMeasurementException;

import java.util.Objects;

public class Temperature {
  private final double value;
  private final TemperatureUnit unit;

  private Temperature(double value, TemperatureUnit unit) {
    this.value = value;
    this.unit = unit;
  }

  public static Temperature create(double value, TemperatureUnit unit) throws InvalidMeasurementException {
    if (value < 0) throw new InvalidMeasurementException(value);

    return new Temperature(value, unit);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Temperature that = (Temperature) o;

    double v1 = this.unit.toStandard(this.value);
    double v2 = that.unit.toStandard(that.value);

    return Math.abs(v1 - v2) < 0.1;
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.value, this.unit);
  }
}
