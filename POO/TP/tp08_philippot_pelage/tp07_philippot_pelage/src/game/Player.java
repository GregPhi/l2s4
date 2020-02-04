package game;

/**
 * Class Player
 *
 * @author : Philippot Gregoire and Pelage François-Xavier
 * @version : 4 mars 2017
 */

public class Player{

  //Attributs
  /*Score of player*/
  private int score;
  /*Name of player*/
  private String name;
  /*Strat of player*/
  private Strategy strat;

  //Constructor
  /**
   * Player
   *
   * @param s : (type-Strategy)
   */
  public Player(Strategy s){
    this.strat = s;
    this.score = 0;
    this.name = "no_name";
  }

  /**
   * Player
   *
   * @param s : (type-Strategy)
   * @param n : (type-String)
   */
  public Player(Strategy s, String n){
    this.strat = s;
    this.score = 0;
    this.name = n;
  }

  //Methods
  /**
   * Get score
   *
   * @return : (type-int)
   */
  public int getScore(){
    return this.score;
  }

  /**
   * Get name
   *
   * @return : (type-String)
   */
  public String getName(){
    return this.name;
  }

  /**
   * Add points
   *
   * @param p : (type-int)
   */
  public void addPoints(int p){
    this.score += p;
  }

  /**
   * Set the previous shape of player
   *
   * @param s : (type-Shape)
   */
  public void setPrevShape(Shape s){
    this.strat.setPrevShape(s);
  }

  /**
   * Play
   *
   * @return : (type-Shape)
   */
  public Shape play(){
    return this.strat.play();
  }

  /**
   * Reset score
   */
  public void reset(){
    this.score = 0;
  }

  /**
   *
   *
   * @param o : (type-Object)
   * @return : (type-boolean)
   */
  public boolean equals(Object o){
    if (!(o instanceof Player)){
      return false;
    }
    Player p = (Player)o;
    return this.strat == p.strat && this.score == p.score;
  }
}
