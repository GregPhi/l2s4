package goosegame;

import java.util.*;
import goosegame.*;
import goosegame.cell.*;
import goosegame.board.*;

/**
 * Class Main
 *
 * @author : Philippot Gregoire and Pelage François-Xavier
 * @version : 1.0
 */

public class Main{

  /**
   * Main of goosegame
   *
   * @param args (type-String[])
   */
  public static void main(String[] args){
    Scanner b1 = new Scanner(System.in);
    System.out.println("Classic Board or Random Board ?, C for classic, R for random.");
    String b = b1.nextLine();
    Board board = new ClassicBoard();
    switch(b){
      case "C" : break;
      case "R" : board = new RandomBoard(63); break;
      default : break;
    }
    //System.out.println("instanceof Board : "+(board instanceof Board));
    //System.out.println("instanceof RandomBoard : "+(board instanceof RandomBoard));
    Game goosegame = new Game(board);
    //Nb of players
    Scanner s = new Scanner(System.in);
    System.out.println("Number of player in this game : ");
    Integer nb_players = s.nextInt();
    //Name of players
    ArrayList<Player> thePlayers = new ArrayList<Player>();
    for(int i = 0; i < nb_players; i++){
      Scanner p = new Scanner(System.in);
      System.out.println("Name of player : ");
      Player player = new Player(p.nextLine(),null);
      thePlayers.add(player);
    }
    //Shuffle
    Collections.shuffle(thePlayers);
    //Add players to game
    for(Player pl : thePlayers){
      goosegame.addPlayer(pl);
    }
    goosegame.play();
  }
}
