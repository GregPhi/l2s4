package game;

import game.strategy.*;
import game.util.input;

/**
 * Class GameMain
 *
 * @author : Philippot Gregoire & Pelage François-Xavier
 *
 */

public class GameMain{
  public static boolean playerstr1 = false;
  public static boolean playerstr2 = false;

  /**
   * Main
   *
   * @param args : (type-String[])
   */
  public static void main(String[] args){
    System.out.println("0 * ScissorsStrat");
    System.out.println("1 * RandomStrat");
    System.out.println("2 * PlayerStrat");
    System.out.println("3 * CounterStrat");
    Input put = new Input();
    Strategy s1 = new RandomStrategy();
    Strategy s2 = new RandomStrategy();
    Player p1;
    Player p2;
    System.out.println("Enter number order of the strategy");
    System.out.println("Strategy of player n°1(if none, this is random)");
    switch(put.readString()){
      case "2" : s1 = new PlayerStrat(); playerstr1 = true; break;
      case "0" : s1 = new ScissorsStrat(); break;
      case "3" : s1 = new CounterStrat(); break;
      default : s1 = new RandomStrategy();
    }
    System.out.println("Strategy of player n°2(if none, this is random)");
    switch(put.readString()){
      case "2" : s2 = new PlayerStrat(); playerstr2 = true; break;
      case "0" : s2 = new ScissorsStrat(); break;
      case "3" : s2 = new CounterStrat(); break;
      default : s2 = new RandomStrategy();
    }
    System.out.println("Name of player n°1 : ");
    p1 = new Player(s1, put.readString());
    System.out.println("Name of player n°2 : ");
    p2 = new Player(s2, put.readString());
    System.out.println("Number of tunrs : ");
    Game g = new Game(p1, p2, put.readInt());
    System.out.println("[R : Rock | P : Paper | S : Scissors ]");
    g.play();
    System.out.println("Winner is " +g.getWinner());
  }
}
