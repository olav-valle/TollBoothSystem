package no.ntnu.exam.model.vehicle;

/**
 * Class representing a vehicle. Holds information used to identify and register a vehicles
 * passage through a toll station.
 * @author 10033
 * @version 0.1
 */

public abstract class Vehicle {

  protected String registrationNumber;
  protected int weight;

  public Vehicle(String regNumber, int weight) {
    if ( regNumber != null && regNumber.trim().equals("")) {
      this.registrationNumber = regNumber;
    } else {
      throw new IllegalArgumentException("Invalid liscence registration number.");
    }
    this.weight = weight;
  }

  /**
   * Returns a string representing this vehicles liscence plate registration number.
   * @return a string representing this vehicles liscence plate registration number.
   */
  public String getRegistrationNumber() {
    return registrationNumber;
  }

  /**
   * Returns the cost of a single toll passage for this vehicle.
   * @param isRushTime Boolean true if passage happens during rush hour, false if not.
   * @return the cost of a passage.
   */
  public abstract double getCost(Boolean isRushTime);
}

