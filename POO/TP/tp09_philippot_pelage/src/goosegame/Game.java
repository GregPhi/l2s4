package goosegame;

import java.util.*;
import goosegame.board.*;
import goosegame.*;
import goosegame.cell.*;

/**
 * Class Game
 *
 * @author : Philippot Gregoire and Pelage François-Xavier
 * @version : 1.0
 */

public class Game{
  //ATTRIBUTS
  /* idx player */
  protected int idxPlayer;
  /* List of Players in this game */
  protected List<Player> thePlayers;
  /* Board */
  protected Board board;
  /* size */
  protected int size;
  /* */
  protected static Scanner scan = new Scanner(System.in);

  //CONSTRUCTOR
  /**
   * Game
   *
   * @param board (type-Board)
   */
  public Game(Board board){
    this.board = board;
    this.thePlayers = new ArrayList<Player>();
    this.idxPlayer = 0;
    this.size = 0;
  }

  //METHODS
  /**
   * add Player in this Player in Game
   *
   * @param player (type-Player)
   */
  public void addPlayer(Player player){
    this.thePlayers.add(player);
    this.size+=1;
  }

  /**
   * Play
   *
   * @return (type-boolean)
   */
  public boolean play(){
    Cell cell = this.board.getCell(this.board.getNbOfCells()-1);
    while(!(cell.isBusy())){
      try{
        playOneRound();
        System.out.println("**********************");
        System.out.println("Press c for continue or l to leave.");
        String str = scan.next();
        if(str.equals("l")){
          return false;
        }
      }catch(IllegalStateException e){
        System.out.println("This is a general loose.");
        return false;
      }
    }
    System.out.println(cell.getPlayer().toString() + " has win.");
    return true;
  }

  /**
   * Play one round
   *
   * @exception IllegalStateException "illegal state exception"
   */
  public void playOneRound(){
    int nbCells = this.board.getNbOfCells();
    int pbl = 0;
    for(Player p : this.thePlayers){
      System.out.println("*************");
      if(p.getCell() != null){
        if(!p.getCell().canBeLeft()){
          if(p.getCell().toString().equals("trapCell")){
            pbl+=1;
            System.out.println(p.toString() + " is stun and pass turn for always.");
          }else{
            System.out.println(p.toString() + " is stun and pass turn for unknow turns.");
          }continue;
        }
      }
      int val = p.twoDiceThrow();
      System.out.println(p.toString() + " launch dice and obtain : " +val);
      advance(val, p, nbCells);
      System.out.println(p.toString() + " is in new cell : " +(p.getCell().getIndex()+1));
      if(p.getCell().getIndex() == p.getCell().handleMove(val)){
        continue;
      }else{
        advance(p.getCell().handleMove(val)-p.getCell().getIndex(), p, nbCells);
        System.out.println("Because goosecell or teleport cell, he is now : " +(p.getCell().getIndex()+1));
      }
    }
  }

  /**
   * Advance
   *
   * @param val (type-Int)
   * @param player (type-Player)
   * @param nbCells (type-Int)
   */
  public void advance(int val, Player player, int nbCells){
    int idx = 0;
    Cell previousCell = null;
    Cell cell = null;
    if(player.getCell() == null){
      idx = -1;
    }else{
      idx = player.getCell().getIndex();
    }
    if(val+idx > (nbCells-1)){
      val=-(val+idx-nbCells);
    }
    if(idx != -1){
      previousCell = this.board.getCell(idx);
      cell = this.board.getCell(val+idx);
      player.setCell(cell);
      previousCell.byePlayer();
    }else{
      cell = this.board.getCell(val-1);
      player.setCell(cell);
    }
    if(cell.isBusy()){
      Player p2 = cell.getPlayer();
      if(previousCell != null){
        p2.setCell(previousCell);
        previousCell.welcomePlayer(p2);
        System.out.println(p2.toString()+" have go cell : "+(previousCell.getIndex()+1));
      }else{
        p2.setCell(null);
        System.out.println(p2.toString()+" have go start cell.");
      }
    }
    cell.welcomePlayer(player);
  }
}
