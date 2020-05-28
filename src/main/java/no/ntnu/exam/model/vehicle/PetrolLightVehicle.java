package no.ntnu.exam.model.vehicle;

/**
 * Represents a petrol fuel vehicle.
 */
public class PetrolLightVehicle extends LightVehicle {

  // costs as final fields makes it easeier to change and keep track of,
  // rather than hiding it inside a method.
  private final double RUSH_TIME_COST = 21;
  private final double COST = 17;

  public PetrolLightVehicle(String regNumber, int weight){

    super(regNumber, weight);
  }

  public double getCost(boolean isRushTime) {
    if (isRushTime) {
      return RUSH_TIME_COST;
    } else {
      return COST;
    }
  }

}
