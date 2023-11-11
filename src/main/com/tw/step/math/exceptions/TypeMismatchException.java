package com.tw.step.math.exceptions;

import com.tw.step.math.models.LengthUnit;

public class TypeMismatchException extends Throwable {
  public final LengthUnit firstUnit;
  public final LengthUnit secondUnit;

  public TypeMismatchException(LengthUnit firstUnit, LengthUnit secondUnit) {
    super("Type mismatch");
    this.firstUnit = firstUnit;
    this.secondUnit = secondUnit;
  }
}
