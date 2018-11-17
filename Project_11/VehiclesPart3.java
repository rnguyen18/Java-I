import java.io.FileNotFoundException;

/**
 * Takes input to put liquid in terms of barrels gallons quarts and ounces.
 * Project 11
 * @author Ryan Nguyen
 * @version 12/6/17
 */

public class VehiclesPart3 
{

   /**
    * Takes input and calculates area of a pyramid.
    * @param args Command line arguments (not used).
    */

   public static void main(String[] args) 
   {
      if (args.length != 0)
      {
         try
         {
         
            UseTaxList t = new UseTaxList();
            t.readVehicleFile(args[0]);
            System.out.println(t.summary() + "\n");
            System.out.println(t.listByOwner() + "\n");
            System.out.println(t.listByUseTax() + "\n");
            System.out.println(t.excludedRecordsList());
         
         }
         catch (FileNotFoundException e)
         {
         
            System.out.println("*** File not found."
               + "\nProgram ending.");
         
         } 
      
      } else {
      
         System.out.println("*** File name "
            + "not provided by command line "
            + "argument.\nProgram ending.");
      
      }
   }


}