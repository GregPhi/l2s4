package game;

/**
 * Interface Strategy
 *
 * @author : Philippot Gregoire & Pelage François-Xavier
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
   *
   *
   * @param s : (type-Shape)
   */
  public void setPrevShape(Shape s);
}
