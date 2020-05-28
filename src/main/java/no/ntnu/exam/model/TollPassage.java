package no.ntnu.exam.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Class representing a single toll booth passage. Contains information about
 * the car that passed, the date and time of the passing, and the cost of the passing.
 */
@Entity
public class TollPassage implements Serializable {
 @Id
 @GeneratedValue
  private int plazaID;
  private String vehicleRegistration;
  private double cost;
  private LocalDate date;
  private LocalTime time;

  /**
   * No-arg constructor.
   */
  public TollPassage(){
  }

  /**
   * Constructor for a Toll Passage.
   * @param time LocalTime object with time of passage.
   * @param date LocalDate object with date of passage.
   * @param vehicleRegistration Lisence plate registration number for the passing vehicle.
   * @param cost Cost of the vehicle passing.
   * @param boothID ID of the booth being passed.
   */
  public TollPassage(LocalTime time,
                     LocalDate date,
                     String vehicleRegistration,
                     double cost,
                     int boothID) {

    // Passing String and primitives, instead of object reference to
    // the passing vehicle, to loosen coupling.

    this.plazaID = boothID; // TODO: 28/05/2020 Check for valid boothID's?

    if (cost >= 0){ //cost should not be negative.
      this.cost = cost;
    } else {
      throw new IllegalArgumentException("Cost cannot be a negative value");
    }
    // lisence regsitration cannot be null or empty string
    if (vehicleRegistration != null && !vehicleRegistration.trim().equals("") ) {
      this.vehicleRegistration = vehicleRegistration;
    } else {
      throw new IllegalArgumentException("Null object or empty string as vehicle lisence registration.");
    }
    // date and time cannot be null
    // TODO: 28/05/2020 add check for valid date range?
    if ( time != null  && date != null) {
      this.date = date;
      this.time = time;
    } else {
      throw new IllegalArgumentException("Time and date cannot be null objects.");
    }

  }

  /**
   * Returns the ID number of the plaza this passing took place at.
   * @return the ID number of the plaza this passing took place at.
   */
  public int getPlazaID() {
    return plazaID;
  }

  /**
   * Returns the lisence plate registration number of the vehicle that passed.
   * @return the lisence plate registration number of the vehicle that passed.
   */
  public String getVehicleRegistration() {
    return vehicleRegistration;
  }

  /**
   * Returns the cost of this passing.
   * @return the cost of this passing.
   */
  public double getCost() {
    return cost;
  }

  /**
   * Returns a LocalDate object describing the date of the passing.
   * @return a LocalDate object describing the date of the passing.
   */
  public LocalDate getDate() {
    return date;
  }

  /**
   * Returns a LocalTime object describing the time of the passing.
   * @return a LocalTime object describing the time of the passing.
   */
  public LocalTime getTime() {
    return time;
  }
}
