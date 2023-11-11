package com.tw.step.math.models;

import com.tw.step.math.exceptions.InvalidRangeException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ChanceTest {
  @Test
  void shouldThrowExceptionForInvalidRange() {
    InvalidRangeException e = assertThrows(InvalidRangeException.class, () -> Chance.initiate(1.2));

    assertEquals(1.2, e.value);
  }

  @Test
  void shouldBeEqual() throws InvalidRangeException {
    Chance c1 = Chance.initiate(0.2);
    Chance c2 = Chance.initiate(0.2);

    assertEquals(c1, c2);
  }

  @Test
  void shouldNotBeEqual() throws InvalidRangeException {
    Chance c1 = Chance.initiate(0.2);
    Chance c2 = Chance.initiate(0.6);

    assertNotEquals(c1, c2);
  }

  @Test
  void shouldInverseChance() throws InvalidRangeException {
    Chance c1 = Chance.initiate(0.2).inverse();

    assertEquals(c1, Chance.initiate(0.8));
  }

  @Test
  void shouldCalculateProbabilityOfOccurringIndependentEvents() throws InvalidRangeException {
    Chance c1 = Chance.initiate(0.5);
    Chance c2 = Chance.initiate(0.5);

    assertEquals(c1.and(c2), Chance.initiate(0.25));
  }

  @Test
  void shouldCalculateProbabilityOfOccurringDependentEvents() throws InvalidRangeException {
    Chance c1 = Chance.initiate(0.5);
    Chance c2 = Chance.initiate(0.5);

    assertEquals(c1.or(c2), Chance.initiate(0.75));
  }
}