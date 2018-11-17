import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.text.DecimalFormat;
   
/**
 * UseTaxClass for methods for reading in data and manipulating it.
 * Project 11
 * @author Ryan Nguyen
 * @version 12/6/17
 */

public class UseTaxList
{
   private String taxDistrict; //  = "not yet assigned.";
   private Vehicle[] vehicleList; //  = new Vehicle[0];
   private String[] excludedRecords; // = new String[0];
   static final DecimalFormat FORM = new DecimalFormat("$#,##0.00#");
   
   /**
    * Constructs the UseTaxList objects.
    */
   public UseTaxList() 
   {
   
      taxDistrict = "not yet assigned.";
      vehicleList = new Vehicle[0];
      excludedRecords = new String[0];
         
   }
   
   /**
    * Returns the taxDistrict string variable.
    * @return taxDistrict variable.
    */ 
   public String getTaxDistrict() 
   {
      
      return taxDistrict;
      
   }
      
   /**
    * Sets new taxDistrict variable.
    * @param taxDistrictIn value taxDistrict is set to.
    */ 
   public void setTaxDistrict(String taxDistrictIn) 
   {
      
      taxDistrict = taxDistrictIn;
      
   }
      
   /**
    * Returns the vehicleList array.
    * @return the vehicle array of vehicleList.
    */ 
   public Vehicle[] getVehicleList()
   {
      
      return vehicleList;
      
   }
      
   /**
    * Returns the excludedRecords array.
    * @return the string array of excludedRecords.
    */ 
   public String[] getExcludedRecords()
   {
      
      return excludedRecords;
      
   }
   
   /**
    * Adds a vehicle to the vehicleList.
    * @param vehicleIn vehicle to be added.
    */ 
   public void addVehicle(Vehicle vehicleIn)
   {
      
      vehicleList = Arrays.copyOf(vehicleList, vehicleList.length + 1);
      vehicleList[vehicleList.length - 1] = vehicleIn;
      
   }
   
   /**
    * Adds a string to the excluded records.
    * @param recordIn string to be added.
    */ 
   public void addExcludedRecord(String recordIn)
   {
      
      excludedRecords = Arrays.copyOf(excludedRecords, 
         excludedRecords.length + 1);
      excludedRecords[excludedRecords.length - 1] = recordIn;
      
   }
      
   /**
    * Returns The string equivalent of the list.
    * @return String equivalent of the list.
    */ 
   public String toString()
   {
   
      String output = "";
         
      for (int i = 0; i < vehicleList.length; i++)
      {
         
         output += "\n" + vehicleList[i] + "\n";
         
      }
         
      return output;
      
   }
      
   /**
    * Returns the calculated total taxes of the list.
    * @return double representing tax of the vehicles.
    */ 
   public double calculateTotalUseTax()
   {
      
      double output = 0;
         
      for (int i = 0; i < vehicleList.length; i++)
      {
         
         output += vehicleList[i].useTax();
         
      }
         
      return output;
      
   }      
      
   /**
    * Returns the calculated total values of the list.
    * @return double representing value of the vehicles.
    */ 
   public double calculateTotalValue()
   {
      
      double output = 0;
      
      for (int i = 0; i < vehicleList.length; i++)
      {
         
         output += vehicleList[i].getValue();
         
      }
         
      return output;
      
   }
     
   /**
    * Reads the summary in a string format.
    * @return the summary of the list including calculated values.
    */ 
   public String summary()
   {
      
      return "------------------------------\n" 
            + "Summary for " + taxDistrict + "\n"
            + "------------------------------\n"
            + "Number of Vehicles: " + vehicleList.length
            + "\nTotal Value: " + FORM.format(calculateTotalValue())
            + "\nTotal Use Tax: " + FORM.format(calculateTotalUseTax()) + "\n";
      
   }
      
   /**
    * Reads vehicle files and creates vehicle list.
    * @param fileNameIn the name of the file to be read.
    * @throws FileNotFoundException used in order to open files.
    */
   public void readVehicleFile(String fileNameIn)
      throws FileNotFoundException {
   
      Scanner scanFile = new Scanner(new File(fileNameIn));
      int count = 0;
      
      taxDistrict = scanFile.nextLine(); 
           
      while (scanFile.hasNext()) {
         char letter = scanFile.nextLine().toUpperCase().charAt(0);
         if (letter == 'C' || letter == 'T'
            || letter == 'S' || letter == 'M')
         {
            count++;
         }
      }
      
      scanFile = new Scanner(new File(fileNameIn));
      vehicleList = new Vehicle[count];
      count = 0;
      
      scanFile.nextLine();
      
      while (scanFile.hasNext()) {
         
         String thisLine = scanFile.nextLine();
         
         try 
         {
            Scanner scanLine = new Scanner(thisLine);
            scanLine.useDelimiter(";");
            
            String vehicleType = scanLine.next().trim();
            
            String owner = scanLine.next().trim();
            
            String vehicleName = scanLine.next().trim();
            
            double price = Double.parseDouble(scanLine.next().trim());
            
            boolean altFuel = Boolean.parseBoolean(scanLine.next().trim());
            
            switch (vehicleType.toUpperCase().charAt(0))
            {
            
               case 'C':
                  vehicleList[count] = new Car(
                     owner, vehicleName, price, altFuel);
                  break;
                  
               case 'T':
                  vehicleList[count] = new Truck(
                     owner, vehicleName, price, altFuel,
                        Double.parseDouble(scanLine.next().trim()));
                  break;
                  
               case 'S':
                  vehicleList[count] = new SemiTractorTrailer(
                     owner, vehicleName, price, altFuel,
                        Double.parseDouble(scanLine.next().trim()),
                        Integer.parseInt(scanLine.next().trim()));
                  break;
              
               case 'M':
                  vehicleList[count] = new Motorcycle(
                     owner, vehicleName, price, altFuel,
                        Double.parseDouble(scanLine.next().trim()));
                  break;
                  
               default:
                  this.addExcludedRecord(
                     "Invalid Vehicle Category in:\n" + thisLine);
                  count--;
                  break;
            }
            count++; 
            
         }
         catch (NumberFormatException e)
         {
         
            this.addExcludedRecord(e 
               + " in:\n" + thisLine);
            vehicleList = Arrays.copyOf(vehicleList, 
               vehicleList.length - 1);
         
         }
         
         catch (NoSuchElementException e)
         {
         
            this.addExcludedRecord(e 
               + " in:\n" + thisLine);
            vehicleList = Arrays.copyOf(vehicleList, 
               vehicleList.length - 1);
         
         }
         
         catch (NegativeValueException e)
         {
         
            this.addExcludedRecord(e 
               + " in:\n" + thisLine);
            vehicleList = Arrays.copyOf(vehicleList, 
               vehicleList.length - 1);
         
         }
         
      }
   
   }
   
   /**
    * Returns the string of vehicleList by owner.
    * @return the string of vehicleList by owner.
    */ 
   public String listByOwner()
   {
   
      Arrays.sort(vehicleList);
      
         
      return "------------------------------\n"
         + "Vehicles by Owner\n" 
         + "------------------------------\n"
         + this.toString();
   
   }
   
   /**
    * Returns the string of vehicleList by tax.
    * @return the string of vehicleList by tax.
    */ 
   public String listByUseTax()
   {
   
      Arrays.sort(vehicleList, new UseTaxComparator()); 
         
      return "------------------------------\n"
         + "Vehicles by Use Tax\n" 
         + "------------------------------\n"
         + this.toString();
   
   } 
   
   /**
    * Returns the string of excludedRecords List.
    * @return the string of excludedRecords List.
    */ 
   public String excludedRecordsList()
   {
   
      String output = "------------------------------\n"
         + "Excluded Records\n" 
         + "------------------------------\n";
         
      for (int i = 0; i < excludedRecords.length; i++)
      {
         
         output += "\n" + excludedRecords[i] + "\n";
         
      }
   
      return output;
   
   }
}
