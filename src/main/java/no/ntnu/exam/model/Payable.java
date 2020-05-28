package no.ntnu.exam.model;

/**
 * An interface used to implement toll booth payments.
 */
public interface Payable {

  /**
   * Returns a string representing this vehicles liscence plate registration number.
   * @return a string representing this vehicles liscence plate registration number.
   */
  public String getLisencePlateNumber();

  /**
   * Returns the cost of a single toll passage for this vehicle.
   * @param isRushTime Boolean true if passage happens during rush hour, false if not.
   * @return the cost of a passage.
   */
  public double getCost(boolean isRushTime);

}
