package hanoi;

import hanoi.*;
import hanoi.util.*;
import hanoi.io.*;

/**
 * Class HanoiInteractiveMain
 *
 * @author : Philippot Gregoire and Pelage François-Xavier
 * @version : 24 fevrier 2017
 */

public class HanoiInteractiveMain{

  /**
   * Usage for the hanoi game
   */
   public static void usage(){
     System.out.println("usage : java hanoiMain <nbDisc>");
     System.out.println(0);
   }

   /**
    * Print the instruction of the game
    */
  public static void instructions(){
    System.out.println("------------------------------ INSTRUCTIONS DU JEU DES TOURS D'HANOI ------------------------------------");
    System.out.println("- Tour de gauche (Tour 0) : g, tour du centre (Tour 1) : c, tour de droite (Tour 2) : d");
    System.out.println("- Pour Effectuer un deplacement, tapez deux lettres : celle de la tour de depart et de la tour d'arrivee.");
    System.out.println("- Exemple : gc, deplcae le disque du sommet de la tour gauche sur celui de la tour du centre.");
    System.out.println("- Vous pouvez quitter a tout moment en saisissant quit");
    System.out.println("---------------------------------------------------------------------------------------------------------");
  }

  /**
   * Game
   *
   * @param args : (type-String[])
   */
  public static void main(String[] args){
    if (args.length != 1){
      usage();
    }else{
      try{
        int capacity = Integer.parseInt(args[0]);
        Hanoi game = new Hanoi(capacity);
        instructions();
        game.display();
        HanoiInput input = new HanoiInput();
        while (!game.isSolved()){
          input.readInput();
          if (input.isMove()){
            if (game.isAllowed(input.getFrom(), input.getTo())){
              game.moveOneDisc(input.getFrom(), input.getTo());
            }else{
              System.out.print("Ce deplacement n'est pas autorise.");
            }
          }else{
            System.out.println("Merci d'avoir joue a ce jeu.");
            System.exit(0);
          }
        }
        System.out.println("Vous avez reussi, FELICITATION !");
      }catch(Exception e){
      }
    }
  }
}
