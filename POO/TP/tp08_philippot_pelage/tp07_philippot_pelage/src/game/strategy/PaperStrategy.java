package game.strategy;

import game.Shape;
import game.Strategy;
import java.util.Random;

/**
 * Class PaperStrategy
 *
 * @author : Philippot Gregoire and Pelage François-Xavier
 * @version : 4 mars2017
 */

public class PaperStrategy implements Strategy{

  //@Overide
  public Shape play(){
    return Shape.PAPER;
  }

  //@Overide
  public void setPrevShape(Shape s){

  }
}
