package no.ntnu.exam.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

/**
 * Class representing a registry holding all registered toll passages.
 * @author 10033
 */
public class TollPassageRegister implements Iterable<TollPassage> {

  private ArrayList<TollPassage> passages;

  /**
   * Constructor for Toll Passage Register.
   */
  public TollPassageRegister() {
    this.passages = new ArrayList<>();
    // TODO: 28/05/2020 Make into a singleton?
  }

  /**
   * Adds a toll passage to the registry.
   *
   * @param passage The toll passage being registered.
   */
  public void registerTollPassage(TollPassage passage) {
    // TODO: 28/05/2020 should this take a premade TollPassage as a parameter,
    //  or should the parameters be used to generate a new TollPassage object?

    if (passage != null) { // null check
      if ( !passages.contains(passage) ) { // previous existence in collection
        this.passages.add(passage);
      } else {
        throw new IllegalArgumentException("TollPassage object already present in registry.");
      }
    } else {
      throw new IllegalArgumentException("Null TollPassage object.");
    }
  }

  /**
   * Returns a list of all registered toll passages.
   *
   * @return a list of all registered toll passages.
   */
  public List<TollPassage> getListOfPassages() {
    return passages;
  }


  /**
   * Returns an iterator of all toll passages in registry.
   *
   * @return an iterator of all toll passages in registry.
   */
  @Override
  public Iterator<TollPassage> iterator() {
    return passages.iterator();
  }

  /**
   * Performs the given action for each toll passage in the registry.
   *
   * @param action the action that is to be performed on each element.
   */
  @Override
  public void forEach(Consumer<? super TollPassage> action) {
    this.passages.forEach(action);

  }
}
