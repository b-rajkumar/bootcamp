package com.tw.step.math.models;

import com.tw.step.math.exceptions.InvalidRange;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ChanceTest {
  @Test
  void shouldThrowExceptionForInvalidRange() {
    InvalidRange e = assertThrows(InvalidRange.class, () -> Chance.initiate(1.2));

    assertEquals(1.2, e.value);
  }

  @Test
  void shouldBeEqual() throws InvalidRange {
    Chance c1 = Chance.initiate(0.2);
    Chance c2 = Chance.initiate(0.2);

    assertEquals(c1, c2);
  }

  @Test
  void shouldNotBeEqual() throws InvalidRange {
    Chance c1 = Chance.initiate(0.2);
    Chance c2 = Chance.initiate(0.6);

    assertNotEquals(c1, c2);
  }

  @Test
  void shouldInverseChance() throws InvalidRange {
    Chance c1 = Chance.initiate(0.2).inverse();

    assertEquals(c1, Chance.initiate(0.8));
  }
}