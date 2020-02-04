package game;

/**
 * Interface Strategy
 *
 * @author : Philippot Gregoire and Pelage François-Xavier
 * @version : 4 mars 2017
 */

public interface Strategy{

  /**
   * Give a shape
   *
   * @return : (type-Shape)
   */
  public Shape play();

  /**
   * This method exists for set a shape on the strat for strategy
   * For scissors, paper, rock : this method is empty
   *
   * @param s : (type-Shape)
   */
  public void setPrevShape(Shape s);
}
