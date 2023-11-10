package com.tw.step.math.models;

import com.tw.step.math.exceptions.InvalidRange;

public class Coin {

  public static Chance chanceOfGettingAllTails(int coinsCount) throws InvalidRange {
    double totalPossibilities = Math.pow(2, coinsCount);
    double probability = 1 / totalPossibilities;

    return Chance.initiate(probability);
  }

  public static Chance chanceOfGettingAtLeastOneTail(int coinsCount) throws InvalidRange {
    double totalPossibilities = Math.pow(2, coinsCount);
    double probability = (totalPossibilities - 1) / totalPossibilities;

    return Chance.initiate(probability);
  }
}