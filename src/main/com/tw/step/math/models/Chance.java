package com.tw.step.math.models;

import com.tw.step.math.exceptions.InvalidRange;

import java.util.Objects;

public class Chance {
  private final double value;

  private Chance(double value) {
    this.value = value;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Chance chance = (Chance) o;
    return Double.compare(this.value, chance.value) == 0;
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.value);
  }

  public static Chance initiate(double value) throws InvalidRange {
    if (value < 0 || value > 1) throw new InvalidRange(value);

    return new Chance(value);
  }

  public Chance inverse() throws InvalidRange {
    return initiate(1 - this.value);
  }
}
