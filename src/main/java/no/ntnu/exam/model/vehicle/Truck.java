package no.ntnu.exam.model.vehicle;

/**
 * Class representing a large vehicle, called a truck.
 */

public class Truck extends Vehicle{

  // costs as final fields makes it easeier to change and keep track of,
  // rather than hiding it inside a method.
  private final double RUSH_TIME_COST = 101;
  private final double COST = 86;
  // FIXME: 28/05/2020 How do we handle not having a max weight, only a minimum weight?

  public Truck(String regNumber, int weight) {
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
