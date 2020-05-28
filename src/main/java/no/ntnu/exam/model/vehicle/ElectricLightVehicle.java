package no.ntnu.exam.model.vehicle;

/**
 * Represents a electric car.
 */
public class ElectricLightVehicle extends LightVehicle {

  // costs as final fields makes it easeier to change and keep track of,
  // rather than hiding it inside a method.
  private final double RUSH_TIME_COST = 8;
  private final double COST = 4;

  public ElectricLightVehicle(String regNumber, int weight){
    super(regNumber, weight);
  }

  public double getCost(Boolean isRushTime) {
    if (isRushTime) {
      return RUSH_TIME_COST;
    } else {
      return COST;
    }
  }

}
