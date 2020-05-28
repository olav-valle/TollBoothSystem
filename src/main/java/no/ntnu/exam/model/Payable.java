package no.ntnu.exam.model;

import com.sun.org.apache.xpath.internal.operations.Bool;

public interface Payable {

  public String getLisencePlateNumber();

  public double getCost(boolean withinRushHours);
}
