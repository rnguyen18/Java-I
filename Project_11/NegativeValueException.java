   /**
 * NegativeValueException so we can exclude negative numbers.
 * Project 11
 * @author Ryan Nguyen
 * @version 12/6/17
 */

public class NegativeValueException extends Exception 
   //extends RuntimeException 
{

   /**
    * Negative number error message.
    */
   public NegativeValueException() {
      super("Numeric values must be nonnegative");
   }

}