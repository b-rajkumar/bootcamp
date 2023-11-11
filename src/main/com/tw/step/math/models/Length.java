package com.tw.step.math.models;

abstract public class Length {
  abstract MilliMeter toStandard();

  public boolean isEqual(Length other) {
    return this.toStandard().equals(other.toStandard());
  }

}
