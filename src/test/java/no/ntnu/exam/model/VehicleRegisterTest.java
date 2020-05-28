package no.ntnu.exam.model;

import static org.junit.jupiter.api.Assertions.*;


import java.sql.SQLOutput;
import java.util.List;
import no.ntnu.exam.model.vehicle.LightVehicle;
import no.ntnu.exam.model.vehicle.Motorcycle;
import no.ntnu.exam.model.vehicle.PetrolLightVehicle;
import no.ntnu.exam.model.vehicle.Truck;
import no.ntnu.exam.model.vehicle.Vehicle;

class VehicleRegisterTest {

  LightVehicle testCar;
  Vehicle testTruck;
  Vehicle testBike;
  VehicleRegister reg;

  @org.junit.jupiter.api.BeforeEach
  void setUp() {
    reg = VehicleRegister.getInstance();
    testCar = new PetrolLightVehicle("UF 32512", 1800);
    testTruck = new Truck("UX 12345", 4500);
    testBike = new Motorcycle("FX 11111", 120);
  }

  @org.junit.jupiter.api.AfterEach
  void tearDown() {
  }

  @org.junit.jupiter.api.Test
  void registerVehicle() {
    System.out.println("Test 1: Adding testCar to registry. Should succed.\n ");
    try {
      reg.registerVehicle(testCar);
      // test should succeed since this is a valid vehicle
      // and it has not been added to the registry yet.
    } catch (IllegalArgumentException e) {
      fail();
      // if an exception was thrown, adding a vehicle failed for some reason.
    }
    System.out.println("Test 2: Adding same car to registry, which should fail. ");
    try {
      reg.registerVehicle(testCar);
      fail(); // should fail since it already exists in registry.
    } catch (IllegalArgumentException e) {
      System.out.println(e.toString());
      System.out.println("Test 2 failed as expected.\n");
    }
    System.out.println("Test 3: Adding null object to registry should fail.");
    try {
      reg.registerVehicle(null);
      fail();
    } catch (IllegalArgumentException e) {
      System.out.println(e.toString());
      System.out.println("Test 3 failed as expected.\n");
    }
  }

  @org.junit.jupiter.api.Test
  void searchByLiscenceRegistration() {
    System.out.println("Adding testCar, testBike and testTruck: ");
    try {
      reg.registerVehicle(testCar);
      reg.registerVehicle(testBike);
      reg.registerVehicle(testTruck);
      // test should succeed since this is a valid vehicle
      // and it has not been added to the registry yet.
    } catch (IllegalArgumentException e) {
      fail();
      // if an exception was thrown, adding a vehicle failed for some reason.
    }
    Vehicle foundCar = reg.searchByLiscenceRegistration(testCar.getLisencePlateNumber());
    Vehicle foundBike = reg.searchByLiscenceRegistration(testBike.getLisencePlateNumber());
    Vehicle foundTruck = reg.searchByLiscenceRegistration(testTruck.getLisencePlateNumber());

    assertEquals(foundCar, testCar,
        "Car: Did not find vehicle with matching registration number.");
    assertEquals(foundBike, testBike,
        "Bike: Did not find vehicle with matching registration number.");
    assertEquals(foundTruck, testTruck,
        "Truck: Did not find vehicle with matching registration number.");
  }

  @org.junit.jupiter.api.Test
  void searchByTotalWeight() {
    System.out.println("Adding testCar and testTruck: ");
    try {
      reg.registerVehicle(testCar);
      reg.registerVehicle(testTruck);
      // test should succeed since this is a valid vehicle
      // and it has not been added to the registry yet.
    } catch (IllegalArgumentException e) {
      fail();
      // if an exception was thrown, adding a vehicle failed for some reason.
    }
    System.out.println("Test 1: Search with 1801. Should find only truck.");
    List<Vehicle> onlyTruck = reg.searchByTotalWeight(1801);
    System.out.println("Asserting that list has only 1 element.");
    assertEquals(onlyTruck.size(), 1);
    System.out.println("Asserting that list contains testTruck.");
    try {
      assert(onlyTruck.contains(testTruck));
    } catch (AssertionError e) {
      fail();
    }
    System.out.println("Test 2: Search with 1800. Should find truck and car. " +
        "\n Search parameter is exactly same as weight of testCar.");
    List<Vehicle> truckAndCar = reg.searchByTotalWeight(1800);
    assertEquals(truckAndCar.size(), 2);
    try {
      assert(truckAndCar.contains(testTruck));
      assert(truckAndCar.contains(testCar));
    } catch (AssertionError e) {
      fail();
    }

    System.out.println("Test 3: Search with 5000. Should find nothing.");
    List<Vehicle> emptyList = reg.searchByTotalWeight(5000);
    assertEquals(emptyList.size(), 0);
  }
}