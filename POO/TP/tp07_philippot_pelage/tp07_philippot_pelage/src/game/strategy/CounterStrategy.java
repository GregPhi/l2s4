package game.strategy;

import game.Shape;
import game.Strategy;
import java.util.Random;

/**
 * Class CounterStrat
 *
 * @author : Philippot Gregoire & Pelage François-Xavier
 * @version : 4 mars2017
 */

public class CounterStrat implements Strategy{

  Shape prev;

  @Overide
  public Shape play(){
    if (prev == null){
      int rdint = new Random().nextInt(3);
      return Shape.values()[rdint];
    }
    switch(prev){
      case ROCK : return Shape.ROCK;
      case SCISSORS : return Shape.SCISSORS;
      case PAPER : return Shape.PAPER;
      default : return this.prev;
    }
  }

  @Overide
  public void setPrevShape(Shape s){
    this.prev = s;
  }
}
