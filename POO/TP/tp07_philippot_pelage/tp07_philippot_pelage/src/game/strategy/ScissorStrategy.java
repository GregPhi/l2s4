package game.strategy;

import game.Shape;
import game.Strategy;
import java.util.Random;

/**
 * Class ScissorsStrat
 *
 * @author : Philippot Gregoire & Pelage François-Xavier
 * @version : 4 mars2017
 */

public class ScissorsStrat implements Strategy{

  @Overide
  public Shape play(){
    return Shape.SCISSORS;
  }

  @Overide
  public void setPrevShape(Shape s){

  }
}
