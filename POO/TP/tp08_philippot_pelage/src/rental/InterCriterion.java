package rental;
import java.util.*;

/**
 * Class InterCriterion implements Criterion
 *
 * @author : Fil Lille 1 and completed by Philippot Gregoire and Pelage François-Xavier
 * @version 1.0
 */

public class InterCriterion implements Criterion {

    private List<Criterion> allCriterions;

    /** creates an InterCriterion with no criterion */
    public InterCriterion() {
        this.allCriterions = new ArrayList<Criterion>();
    }

    /** adds a new criterion
    * @param c the added criterion
    */
    public void addCriterion(Criterion c) {
        this.allCriterions.add(c);
    }

    /** This is satisfied if each of its criterion is satisfied.
     * @see Criterion#isSatisfiedBy(Vehicle) */
    public boolean isSatisfiedBy(Vehicle v) {
      if (this.allCriterions == null){
        return true;
      }
      for (Criterion crit : this.allCriterions){
        if (!crit.isSatisfiedBy(v)){
          return false;
        }
      }
      return true;
    }
}
