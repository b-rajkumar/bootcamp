package com.tw.step.math.models;

import com.tw.step.math.exceptions.InvalidMeasurementException;

import java.util.Objects;

public class Volume {
  private final double value;
  private final VolumeUnit unit;

  public Volume(double value, VolumeUnit unit) {
    this.value = value;
    this.unit = unit;
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

  public static Volume create(double value, VolumeUnit unit) throws InvalidMeasurementException {
    if (value < 0) throw new InvalidMeasurementException(value);

    return new Volume(value, unit);
  }
}
