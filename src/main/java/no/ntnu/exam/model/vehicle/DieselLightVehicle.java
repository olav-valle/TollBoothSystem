package no.ntnu.exam.model.vehicle;

/**
 * Represents a diesel fuel vehicle.
 */
public class DieselLightVehicle extends LightVehicle {

  // costs as final fields makes it easeier to change and keep track of,
  // rather than hiding it inside a method.
  private final double RUSH_TIME_COST = 23;
  private final double COST = 19;

  public DieselLightVehicle(String regNumber, int weight){
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
