package no.ntnu.exam.model;

import java.time.LocalDate;
import java.time.LocalTime;
import no.ntnu.exam.model.vehicle.LightVehicle;
import no.ntnu.exam.model.vehicle.Motorcycle;
import no.ntnu.exam.model.vehicle.PetrolLightVehicle;
import no.ntnu.exam.model.vehicle.Truck;
import no.ntnu.exam.model.vehicle.Vehicle;

/**
 * Simple client for testing the TollPlaza and all its registries.
 * @author 10033
 * @version 0.1
 */
public class TollPlazaClient {

  public static void main(String[] args) {

    try {
      LocalTime nonRush = LocalTime.of(12, 0);
      LocalTime rushHour = LocalTime.of(7, 0);

      TollPlaza toll = new TollPlaza("Vikebukt bomstasjon", 12345);

      Vehicle testBike = new Motorcycle("FX 11111", 120);
      VehicleRegister.getInstance().registerVehicle(testBike);
      toll.registerTollPassage(testBike.getLisencePlateNumber(), LocalDate.now(), LocalTime.now());

      LightVehicle testCar = new PetrolLightVehicle("UF 32512", 1800);
      VehicleRegister.getInstance().registerVehicle(testCar);
      toll.registerTollPassage(testCar.getLisencePlateNumber(), LocalDate.now(), nonRush);

      Vehicle testTruck = new Truck("UX 12345", 4500);
      VehicleRegister.getInstance().registerVehicle(testTruck);
      toll.registerTollPassage(testTruck.getLisencePlateNumber(), LocalDate.now(), rushHour);

      toll.listAllPassages();


    } catch (Exception e) {
      // Catch all exceptions that get this far.
      // TODO: 28/05/2020 make this catch more elegant and granular.
      e.toString();
      e.printStackTrace();
    }
  }

}
