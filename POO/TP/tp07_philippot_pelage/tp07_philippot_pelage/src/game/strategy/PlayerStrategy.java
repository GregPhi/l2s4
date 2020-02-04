package game.strategy;

import game.Shape;
import game.Strategy;
import java.util.Random;

/**
 * Class PlayerStrat
 *
 * @author : Philippot Gregoire & Pelage François-Xavier
 * @version : 4 mars2017
 */

public class PlayerStrat implements Strategy{

  @Overide
  public Shape play(){
    String choise = new Input().readString();
    switch(choise){
      case "R" : return Shape.ROCK;
      case "S" : return Shape.SCISSORS;
      case "P" : return Shape.PAPER;
      default : System.out.print("Only P, R, or S are authorizes");
      return this.play();
    }
  }

  @Overide
  public void setPrevShape(Shape s){

  }
}
