package com.tw.step.math.models;

import com.tw.step.math.exceptions.InvalidRange;

public class Coin {
  private static double calculateTotalOutcomes(int coinsCount) {
    return Math.pow(2, coinsCount);
  }

  public static Chance chanceOfGettingAllTails(int coinsCount) throws InvalidRange {
    double totalOutcomes = calculateTotalOutcomes(coinsCount);
    double probability = 1 / totalOutcomes;

    return Chance.initiate(probability);
  }

  public static Chance chanceOfGettingAtLeastOneTail(int coinsCount) throws InvalidRange {
    double totalOutcomes = calculateTotalOutcomes(coinsCount);
    double probability = (totalOutcomes - 1) / totalOutcomes;

    return Chance.initiate(probability);
  }
}
