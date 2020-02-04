package game;

import game.strategy.*;
import game.util.*;
import java.util.*;

/**
 * Class GameMain
 *
 * @author : Philippot Gregoire and Pelage François-Xavier
 * @version : 13 mars 2017
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
    System.out.println("0 * ScissorStrat");
    System.out.println("1 * RockStrat");
    System.out.println("2 * PaperStrat");
    System.out.println("3 * RandomStrat");
    System.out.println("4 * PlayerStrat");
    Input put = new Input();
    Strategy s1 = new RandomStrategy();
    Strategy s2 = new RandomStrategy();
    Player p1;
    Player p2;
    System.out.println("Enter number order of the strategy");
    System.out.println("Strategy of player n°1(if none, this is random)");
    switch(put.readString()){
      case "0" : s1 = new ScissorStrategy(); break;
      case "1" : s1 = new RockStrategy(); break;
      case "2" : s1 = new PaperStrategy(); break;
      case "4" : s1 = new PlayerStrategy(); playerstr1 = true; break;
      default : s1 = new RandomStrategy();
    }
    System.out.println("Strategy of player n°2(if none, this is random)");
    switch(put.readString()){
      case "0" : s2 = new ScissorStrategy(); break;
      case "1" : s2 = new RockStrategy(); break;
      case "2" : s2 = new PaperStrategy(); break;
      case "4" : s2 = new PlayerStrategy(); playerstr2 = true; break;
      default : s2 = new RandomStrategy();
    }
    System.out.println("Name of player n°1 : ");
    p1 = new Player(s1, put.readString());
    System.out.println("Name of player n°2 : ");
    p2 = new Player(s2, put.readString());
    System.out.println("Number of tunrs : ");
    Scanner input = new Scanner(System.in);
    int bo = input.nextInt();
    Game g = new Game(p1, p2, bo);
    System.out.println("[R : Rock | P : Paper | S : Scissors ]");
    g.play();
    System.out.println("Winner is " +g.getWinner());
  }
}
