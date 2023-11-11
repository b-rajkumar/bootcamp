package com.tw.step.math.models;

import com.tw.step.math.exceptions.InvalidMeasurementException;

import java.util.Objects;

public class Volume {
  private final double value;
  private final Unit unit;

  public Volume(double value, Unit unit) {
    this.value = value;
    this.unit = unit;
  }

  public enum Unit {
    GALLON(3.78),
    LITER(1);

    private final double conversionFactor;

    Unit(double conversionFactor) {
      this.conversionFactor = conversionFactor;
    }

    public double toStandard(double value) {
      return value * this.conversionFactor;
    }
  }
  
  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Volume volume = (Volume) o;

    double v1 = this.unit.toStandard(this.value);
    double v2 = volume.unit.toStandard(volume.value);

    return Math.abs(v1 - v2) < 1;
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.value, this.unit);
  }

  public static Volume create(double value, Unit unit) throws InvalidMeasurementException {
    if (value < 0) throw new InvalidMeasurementException(value);

    return new Volume(value, unit);
  }

  public Volume add(Volume volume) throws InvalidMeasurementException {
    double v1 = this.unit.toStandard(this.value);
    double v2 = volume.unit.toStandard(volume.value);

    return Volume.create(v1 + v2, Unit.LITER);
  }

}
