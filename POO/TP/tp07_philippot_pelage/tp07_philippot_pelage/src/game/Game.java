package game;

import game.strategy.*;

/**
 * Class Game
 *
 * @author : Philippot Gregoire & Pelage François-Xavier
 * @version : 4 mars 2017
 */

public class Game{

  //Attributs
  /*Player 1*/
  private Player p1;
  /*Player 1*/
  private Player p2;
  /*Number of turns in this party (bo : best of)*/
  private int bo;
  /*turn make in this game*/
  private int turn;

  //Constructor
  /**
   * Create Game
   *
   * @param p1 : (type-Player)
   * @param p2 : (type-Player)
   * @param t : (type-int)
   */
  public Game(Player p1, Player p2, int t){
    this.p1 = p1;
    this.p2 = p2;
    this.bo = t;
    this.turn = 0;
  }

  //Methods
  /**
   * Get player 1
   *
   * @return : (type-Player)
   */
  public Player getP1(){
    return this.p1;
  }

  /**
   * Get player 2
   *
   * @return : (type-Player)
   */
  public Player getP2(){
    return this.p2;
  }

  /**
   * Get winner of this gamer
   *
   * @return : (type-String)
   */
  public String getWinner(){
    if(this.p1.getScore() < this.p2.getScore()){
      return this.p2.getName();
    }
    if(this.p1.getScore() > this.p2.getScore()){
      return this.p1.getName();
    }
    return "no winner";
  }

  /**
   * Reset game
   */
  public void reset(){
    this.turn = 0;
    this.p1.reset();
    this.p2.reset();
  }

  /**
   * Play one round
   */
  public void playOneRound(){
    if (GameMain.playerstr1){
      System.out.print(this.p1.getName() +" : ");
    }
    Shape s1 = this.p1.play();
    if (GameMain.playerstr2){
      System.out.print(this.p2.getName() +" : ");
    }
    Shape s2 = this.p2.play();
    System.out.println(this.p1.getName() + " play " +s1.toString());
    System.out.println(this.p2.getName() + " play " +s2.toString());
    this.p1.setPrevShape();
    this.p2.setPrevShape();
    int result = s1.compare(s2);
    if (result == 0){
      System.out.println("Draw round \n");
      this.p1.addPoints(1);
      this.p2.addPoints(1);
    }
    else if (result < 0){
      System.out.println("Round for " +this.p2.getName()+"\n");
      this.p1.addPoints(0);
      this.p2.addPoints(2);
    }
    else{
      System.out.println("Round for " +this.p1.getName()+"\n");
      this.p1.addPoints(2);
      this.p2.addPoints(0);
    }
    this.turn++;
  }

  /**
   * Play
   */
  public void play(){
    while (this.turn < this.bo){
      this.playOneRound();
    }
  }

  /**
   *
   *
   * @param o : (type-Object)
   * @return : (type-boolean)
   */
  public boolean equals(Object o){
    if (!(o instanceof Game)){
      return false;
    }
    Game a = (Game)o;
    return this.p1.equals(a.getP1()) && this.p2.equals(a.getP2());
  }
}
