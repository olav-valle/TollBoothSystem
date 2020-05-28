package no.ntnu.exam.model;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import no.ntnu.exam.model.vehicle.Vehicle;

/**
 * A class holding a collection of registered unique vechicles.
 */
public class VehicleRegister {

  // HashMap with vehicle registration number as key makes searching easier.
  private HashMap<String, Vehicle> vehicles;
  private static VehicleRegister instance;

  /**
   * Private VehicleRegister constructor, used to make class a singleton.
   * By making the constructor private, we ensure that no outside class
   * is able to create instances of this class.
   */
  private VehicleRegister() {
    this.vehicles = new HashMap<String, Vehicle>();
  }

  /**
   * Returns an instance of the Vehicle Registry. If one does not exist yet, it is created.
   * By doing this, we ensure that all users of this class use the same instance.
   * @return An instance of the Vehicle Registry.
   */
  public static VehicleRegister getInstance() {
    // Lazily initiated instance.
    if (instance == null) {
      instance = new VehicleRegister();
    }
    return instance;
  }

  /**
   * Adds a vehicle to the registry.
   */
  public void registerVehicle(Vehicle vehicle) {
    //sanity check for null object and presence in registry
    if (vehicle != null && !vehicles.containsKey(vehicle.getLisencePlateNumber())) {
      vehicles.put(vehicle.getLisencePlateNumber(), vehicle);
    } else {
      throw new IllegalArgumentException("Cannot add an invalid vehicle to registry. \n" +
          "Object was null, or had invalid reg number.");
    }

  }


  /**
   * Searches the registry for a vehicle that matches the liscence
   * plate registration number provided.
   * @param lisenceReg The liscence plate registration number to search for.
   * @return The Vehicle matching the plate number, or null if no match was found.
   */
  public Vehicle searchByLiscenceRegistration(String lisenceReg) {
    return vehicles.get(lisenceReg);
    // FIXME: 28/05/2020 get(lisenceReg) returns null if no match found.
  }

  /**
   * Finds all vehicles with a weight at or above the specified weight.
   * @return Returns a list of all vehicles that matches weight criteria.
   */
  public List<Vehicle> searchByTotalWeight(int weight) {
    return vehicles.values().stream().filter( v -> (v.getWeight() >= weight) ).collect(Collectors.toList());

  }

}
