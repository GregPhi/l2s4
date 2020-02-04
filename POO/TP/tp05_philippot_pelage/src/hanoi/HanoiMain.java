package hanoi;

import hanoi.*;
import hanoi.util.*;
import hanoi.io.*;

/**
 * Class HanoiMain
 *
 * @author : Philippot Gregoire and Pelage François-Xavier
 * @version : 21 février 2017
 */

public class HanoiMain{
  
  /**
   * Usage for the hanoi game
   */
   public static void usage(){
     System.out.println("usage : java hanoiMain <nbDisc>");
     System.out.println(0);
   }

  public static void main(String[] args){
    if (args.length != 1){
      usage();
    }else{
      int capacity = Integer.parseInt(args[0]);
      Hanoi game = new Hanoi(capacity);
      game.solve(capacity, 0, 1, 2);
    }
  }
}
