package no.ntnu.exam.model.vehicle;

/**
 * Abstract implementation for all light vehicles, aka. "cars".
 */
public abstract class LightVehicle extends Vehicle {

  private final int MAX_WEIGHT = 3500;

  public LightVehicle(String regNumber, int weight) {

    // TODO: 28/05/2020 implement check that weight is under MAX_WEIGHT and handle it.
    super(regNumber, weight);
  }

}
