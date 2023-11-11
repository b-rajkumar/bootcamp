package com.tw.step.math.exceptions;

import com.tw.step.math.models.Length;

public class TypeMismatchException extends Throwable {
  public final Length.Unit firstUnit;
  public final Length.Unit secondUnit;

  public TypeMismatchException(Length.Unit firstUnit, Length.Unit secondUnit) {
    super("Type mismatch");
    this.firstUnit = firstUnit;
    this.secondUnit = secondUnit;
  }
}
