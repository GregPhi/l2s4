package game.strategy;

import game.Shape;
import game.Strategy;
import java.util.Random;

/**
 * Class ScissorsStrat
 *
 * @author : Philippot Gregoire and Pelage François-Xavier
 * @version : 4 mars2017
 */

public class ScissorStrategy implements Strategy{

  //@Overide
  public Shape play(){
    return Shape.SCISSORS;
  }

  //@Overide
  public void setPrevShape(Shape s){

  }
}
