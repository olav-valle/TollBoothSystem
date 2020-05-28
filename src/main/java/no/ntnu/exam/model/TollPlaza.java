package no.ntnu.exam.model;

import java.time.LocalTime;

public class TollPlaza {

  // Start and end of morning rush hour
  private final LocalTime MORNING_RUSH_START = LocalTime.of(6, 30);
  private final LocalTime MORNING_RUSH_END = LocalTime.of(8, 59);

  // Start and end of evening rush hour
  private final LocalTime EVENING_RUSH_START = LocalTime.of(14, 30);
  private final LocalTime EVENING_RUSH_END = LocalTime.of(16, 29);

  private TollPassageRegister tollPassages;
  private VehicleRegister vehicleRegister;

  public TollPlaza() {
    this.tollPassages = new TollPassageRegister();
    this.vehicleRegister = VehicleRegister.getInstance();
  }
}
