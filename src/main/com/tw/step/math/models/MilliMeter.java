package com.tw.step.math.models;

import java.util.Objects;

public class MilliMeter {
  private final double value;

  public MilliMeter(double value) {
    this.value = value;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    MilliMeter that = (MilliMeter) o;
    return Math.round(this.value) == Math.round(that.value);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.value);
  }
}
