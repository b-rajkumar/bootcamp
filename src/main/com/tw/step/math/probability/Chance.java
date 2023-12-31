package com.tw.step.math.probability;

import com.tw.step.math.probability.exceptions.InvalidRangeException;

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

  public static Chance initiate(double value) throws InvalidRangeException {
    if (value < 0 || value > 1) throw new InvalidRangeException(value);

    return new Chance(value);
  }

  public Chance inverse() throws InvalidRangeException {
    return Chance.initiate(1 - this.value);
  }

  public Chance and(Chance chance) throws InvalidRangeException {
    return Chance.initiate(this.value * chance.value);
  }

  public Chance or(Chance chance) throws InvalidRangeException {
    Chance inverseOfC1 = this.inverse();
    Chance inverseOfC2 = chance.inverse();

    return inverseOfC1.and(inverseOfC2).inverse();
  }
}
