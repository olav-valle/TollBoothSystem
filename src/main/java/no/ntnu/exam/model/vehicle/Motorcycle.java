package no.ntnu.exam.model.vehicle;

/**
 * Class representing a motorcycle.
 */
public class Motorcycle extends Vehicle {

  // costs as final fields makes it easeier to change and keep track of,
  // rather than hiding it inside a method.
  private final double RUSH_TIME_COST = 0;
  private final double COST = 0;
  private final int MAX_WEIGHT = 3500;

  public Motorcycle(String regNumber, int weight) {
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
