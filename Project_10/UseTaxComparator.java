import java.util.Comparator;

/**
 * UseTaxComparator for comparing by Tax.
 * Project 10
 * @author Ryan Nguyen
 * @version 12/1/17
 */   
public class UseTaxComparator implements Comparator<Vehicle> {
   
   /**
    * Comparing by Tax.
    * @param v1 vehicle to compare to v2
    * @param v2 vehicle to compare to v1
    * @return int based on comparison
    */
   public int compare(Vehicle v1, Vehicle v2) {
      if (v1.useTax() > v2.useTax()) {
         return 1;
      }
      else if (v1.useTax() < v2.useTax()) {
         return -1;
      }
      return 0;
   }
}