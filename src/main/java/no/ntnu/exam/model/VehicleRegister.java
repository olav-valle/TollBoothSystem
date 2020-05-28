package no.ntnu.exam.model;

import java.util.HashMap;
import no.ntnu.exam.model.vehicle.Vehicle;

/**
 * A class holding a collection of registered unique vechicles.
 */
public class VehicleRegister {

  private HashMap<String, Vehicle> vehicles;

  /**
   * VehicleRegister constructor.
   */
  public VehicleRegister() {
    // TODO: 28/05/2020 Make singleton.
    this.vehicles = new HashMap<String, Vehicle>();
  }



}
