package com.tw.step.math.models;

import com.tw.step.math.exceptions.InvalidMeasurementException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class VolumeTest {
  @Test
  void oneGallonShouldBeEqualToApproxThreeLiters() throws InvalidMeasurementException {
    Volume oneGallon = Volume.create(1, VolumeUnit.GALLON);
    Volume threePointSevenLiters = Volume.create(3.78, VolumeUnit.LITER);

    assertEquals(oneGallon, threePointSevenLiters);
  }

  @Test
  void shouldThrowExceptionForNegativeValues() {
    InvalidMeasurementException e = assertThrows(InvalidMeasurementException.class, () -> Volume.create(-1, VolumeUnit.GALLON));
    assertEquals(e.value, -1);
  }

  @Test
  void shouldAddTwoVolumesOfDifferentUnit() throws InvalidMeasurementException {
    Volume oneGallon = Volume.create(1, VolumeUnit.GALLON);
    Volume oneLiter = Volume.create(1, VolumeUnit.LITER);
    Volume fourPointSevenLiters = Volume.create(4.78, VolumeUnit.LITER);

    assertEquals(oneGallon.add(oneLiter), fourPointSevenLiters);
  }

}
