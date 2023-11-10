package com.tw.step.math.models;

import com.tw.step.math.exceptions.InvalidRange;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CoinTest {
  @Test
  void shouldCalculateChanceOfAllTails() throws InvalidRange {
    assertEquals(Coin.chanceOfGettingAllTails(2), Chance.initiate(0.25));
  }

  @Test
  void shouldCalculateChanceOfAtLeastOneTail() throws InvalidRange {
    assertEquals(Coin.chanceOfGettingAtLeastOneTail(2), Chance.initiate(0.75));
  }
}