package no.ntnu.exam.model;

import java.time.LocalDate;
import java.time.LocalTime;
import no.ntnu.exam.model.vehicle.Vehicle;

/**
 * Class representing a Toll Booth Plaza.
 */
public class TollPlaza {

  // Start and end of morning rush hour
  private final LocalTime MORNING_RUSH_START = LocalTime.of(6, 30);
  private final LocalTime MORNING_RUSH_END = LocalTime.of(8, 59);

  // Start and end of evening rush hour
  private final LocalTime EVENING_RUSH_START = LocalTime.of(14, 30);
  private final LocalTime EVENING_RUSH_END = LocalTime.of(16, 29);

  // Toll Passages and Vehicles registries.
  private TollPassageRegister tollPassages;

  //
  private String name;
  private int ID;

  /**
   * Constructor for Toll Plaza class.
   * @param name String representation of the Toll Plaza.
   * @param ID Integer representing the unique ID number for the plaza.
   */
  public TollPlaza(String name, int ID) {

    if (name != null && !name.trim().equals("")) {
      this.name = name;
    } else {
      throw new IllegalArgumentException("Name cannot be empty or null.");
    }

    if (ID >= 0) {
      this.ID = ID;
    } else {
      throw new IllegalArgumentException("Plaza ID cannot be a negative number.");
    }

    this.tollPassages = new TollPassageRegister();
  }

  /**
   * Registeres a vehicle passing the toll plaza.
   * @param vehicleRegistration The lisence registration of the vehicle.
   * @param date The date of passing.
   * @param time The time of passing.
   * @return True if passage was successfully registered.
   */
  public boolean registerTollPassage(String vehicleRegistration, LocalDate date, LocalTime time) {

    Vehicle passingVehicle = VehicleRegister.getInstance()
        .searchByLiscenceRegistration(vehicleRegistration);
    // check if vehicle exists

    boolean isRushHour = isRushHour(time); // check if rush hour

    if (passingVehicle != null) {
      tollPassages.registerTollPassage(
          new TollPassage(
              time, date, vehicleRegistration,
              passingVehicle.getCost(isRushHour),
              this.ID));
    } else {
      throw new IllegalArgumentException("Null passingVehicle");
    }
    return false;
  }

  /**
   * Tests the parameter LocalTime and checks if its in either of the two rush hour periods.
   * @param passTime The time to check.
   * @return True if passTime is inside rush hours, false if not.
   */
  private boolean isRushHour(LocalTime passTime) {
    boolean isRushHour = false;
    if (passTime.isAfter(MORNING_RUSH_START) && passTime.isBefore(MORNING_RUSH_END)) {
      isRushHour = true;
    } else if (passTime.isAfter(EVENING_RUSH_START) && passTime.isBefore(EVENING_RUSH_END)) {
      isRushHour = true;
    }
    return isRushHour;
  }

  /**
   * Sums up and returns total cost of all passages registered to this plaza's ID number.
   * @return total cost of all passages for this plaza.
   */
  public double totalCosts(){
    return tollPassages.getListOfPassages()
        .stream()
        .filter(p -> p.getPlazaID() == this.ID)
        .map(TollPassage::getCost)
        .reduce(0.0, Double::sum);

  }

  /**
   * Prints the information on all passages for this Plaza.
   */
  public void listAllPassages(){
    tollPassages.forEach(
        t -> System.out.println(
            "Plaza ID: " + t.getPlazaID() +
            "\nDate: " + t.getDate().toString() +
            "\nTime: " + t.getTime().toString() +
            "\nVehicle Registration Number: " + t.getVehicleRegistration() +
            "\nCost: " + t.getCost()));

    System.out.println("Total cost of all passages at this toll plaza: " + totalCosts());
  }
}
