package game.strategy;

import game.Shape;
import game.Strategy;
import java.util.Random;

/**
 * Class RandomStrat
 *
 * @author : Philippot Gregoire and Pelage François-Xavier
 * @version : 4 mars2017
 */

public class RandomStrategy implements Strategy{

  //@Overide
  public Shape play(){
    int rdint = new Random().nextInt(3);
    return Shape.values()[rdint];
  }

  //@Overide
  public void setPrevShape(Shape s){

  }
}
