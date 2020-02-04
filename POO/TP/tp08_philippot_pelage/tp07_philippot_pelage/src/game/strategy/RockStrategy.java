package game.strategy;

import game.Shape;
import game.Strategy;
import java.util.Random;

/**
 * Class RockStrategy
 *
 * @author : Philippot Gregoire and Pelage François-Xavier
 * @version : 4 mars2017
 */

public class RockStrategy implements Strategy{

  //@Overide
  public Shape play(){
    return Shape.ROCK;
  }

  //@Overide
  public void setPrevShape(Shape s){

  }
}
