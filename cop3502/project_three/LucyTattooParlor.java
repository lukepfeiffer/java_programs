import java.util.Scanner;
/*
  Name: Luke Pfeiffer
  ID: 4363-4185
  Section Number: 128H
  This is a program that helps to organize and plan tattoos at Lucy's tattoo parlor!
  This was needed to prevent people from making a late night mistake.
*/

public class LucyTattooParlor{
  public static void main(String args[]){
    Scanner scan = new Scanner(System.in);

    // Args passed in through the command line.
    // First args is the number of artists working
    // Second args is the number of customers an artist can take
    int numArtists = Integer.parseInt(args[0]);
    int customerPerArtist = Integer.parseInt(args[1]);


    // Populate two dim. array of customers per artist.
    TattooCustomer[][] customers = populateCustomers(numArtists, customerPerArtist, scan);
    print(customers);
    System.out.println("The program is done!");
  }

  public static TattooCustomer[][] populateCustomers(int numArtists, int customerPerArtist, Scanner scan){
    int maxMinutes = 480; // Equilivent to 8 hours

    // I would've just named the args for this method row and column but
    // I feel like this approach improves readability for future use.
    int row = numArtists;
    int col = customerPerArtist;

    TattooCustomer[][] customers = new TattooCustomer[row][col];

    // As long as there is at least one spot open for an artist,
    // try to put a customer on an artist list
    while(moreAvalibility(customers)){
      System.out.println("Customer name: ");
      String name = scan.next();

      System.out.println("Customer's tattoo: ");
      String tattoo = scan.next();

      // This is kind of hacky. Because print waitlist is two words,
      // use scanner.nextLine would grab the wrong elements sometimes.
      // This is to ensure that I get the correct name here
      if((name + " " + tattoo).equalsIgnoreCase("Print Waitlist")){
        break;
      }


      System.out.println("Time estimate (minutes): ");
      int minutes = scan.nextInt();

      System.out.println("Would this customer like a specific artist? (yes or no)");
      String response = scan.next();

      TattooCustomer customer = new TattooCustomer(name, tattoo, minutes);
      // If the customer wants a specific artist, run method to do so
      if(response.equalsIgnoreCase("yes")){

        System.out.println("Which artist? (0 - " + (numArtists-1) + ")");
        int artistIndex = scan.nextInt();

        // If a customer is successfully added to an artist list, then say yay!
        if(addCustomer(customers, customer, artistIndex)){
          System.out.println("Successfully added customer to " + artistIndex + "!");

        // Else, print out an error message
        } else{
          System.out.println("Looks like there is no availibility for that artist...sorry!");
        }

      } else {

        // This run through only takes in a a customer and the two d customers array!
        if(addCustomer(customers, customer)){
          System.out.println("Successfully added customer to list!");

        // Else, print out an error message
        } else{
          System.out.println("Looks like there is no availibility...sorry!");
        }
      }
    }

    System.out.println("No more availible spots!");

    return customers;
  }

  /**
   * Checks whether or not a customer could potentially be put on someone's list
   * Only checks to see if at least one artist has an open spot.
   * @params TattooCustomer[][]
   */

  public static boolean moreAvalibility(TattooCustomer[][] customers){
    boolean flag = false;

    // Set size of the two d array
    int row = customers.length;
    int col = customers[0].length;

    // This loop goes through all the artists and checks to see if there is at least one
    // availible spot for one of the artists.

    for(int i = 0; i < row; ++i){
      int numMinutes = 0;
      for(int j = 0; j < col; ++j){
        // Add value as long as the array does not point to null
        if(customers[i][j] != null){
          numMinutes += customers[i][j].getMinutes();
        }

        // If the numMinutes is ever greater than or equal to 480 (8 hours) then break out of the second loop 
        // Otherwise, there is at least one open spot for an artist
        if(numMinutes >= 480){
          break;
        } else {
          flag = true;
        }
      }

      // If at any point one of the loops returns true,
      if(flag){
        break;
      }
    }
    return flag;
  }

  /**
   * Computes how many minutes of work the specified tattoo artist has.
   * @param The array of customers for one particular tattoo artist.
   * @return number of minutes for the customer's wait.
   */

  public static int computeMinutesOfWork(TattooCustomer [] a) {
    int numMinutes = 0;

    // Runs the loop equal to the number of columns in the array passed to the method.
    // Because unfilled slots for the array are filled with null, check to make sure
    // that is no added to the sum variable.
    for(int i = 0; i < a.length; ++i){
      if(a[i] == null){
        break;
      } else {
        numMinutes += a[i].getMinutes();
      }
    }

    return numMinutes;
  }

  public static void print(TattooCustomer[][] customers){
    System.out.println("Here is the list:");
    int row = customers.length;
    // Because all sub arrays are the same length, set the col number here!
    int col = customers[0].length;
    for(int i = 0; i < row; ++i){
      for(int j = 0; j < col; ++j){
        TattooCustomer customer = customers[i][j];
        if(customer != null){
          System.out.print(customer.getName() + " " + customer.getTattoo() + " " + customer.getMinutes() + " ");
        }
      }
      System.out.println();
    }
  }

  /**
   * Note* Overload of the addCustomer method if a customer wants a specific artist.
   * Adds customer to the waitlist for a specific artist.
   * If the artist is at capacity (in terms of number of customers or minutes)
   * Then the customer is not added and the method returns false
   * If the customer is successfully added the method returns true
   * @param TattooCustomer[][], TattooCustomer, int artist number
  */

  public static boolean addCustomer(TattooCustomer [][] a, TattooCustomer c, int artistNum) {
    boolean returnFlag = false;
    // Iterate through the specific artists list and see if a spot is open and 
    // there is time to do it.

    // Check if adding this new customer to the list will go over 8 hours one time
    // rather than checking a bunch inside the for loop.

    boolean lessThan8Hours = (computeMinutesOfWork(a[artistNum]) + c.getMinutes()) <= 480;

    for(int i = 0; i < a[artistNum].length; ++i){

      // Check if the function is "addable" meaning if this artists row has time for 
      // the addition of this customer.

      boolean isAddable = a[artistNum][i] == null && lessThan8Hours;
      if(isAddable){
        // If there is a spot open, add the customer to the two d array
        // and break out of the for loop to prevent overwriting data.
        a[artistNum][i] = c;
        returnFlag = true;
        break;
      }
    }

    return returnFlag;
  } 
  /**
   * Note* Overload of the addCustomer method if a customer wants a specific artist.
   * Adds customer to the shortest waitlist in terms of minutes. If some artists have equal length waitlists
   * then the customer is added to the lowest numbered artist. If no artist has space then the method does not
   * add the customer, and returns false.
   * @param TattooCustomer[][] TattooCustomer
   * @return true if the customer was added to the waitlist, false otherwise (if all artists were full)
  */
  public static boolean addCustomer(TattooCustomer [][] a, TattooCustomer c) {
    boolean returnFlag = false;
    int maxMinutes = 480; // 8 hours

    // This method  will return the array of the list with the shortest wait time.
    // Because we check if there is a space open above (null check), we do not need to check again.

    TattooCustomer [] shortestLine = minimumWait(a);
    // Check if the line the customer wants to go to would have a wait over 8 hours with the 
    // addition of this customer.

    boolean lessThan8Hours = (computeMinutesOfWork(shortestLine) + c.getMinutes()) <= 480;

    for(int i = 0; i < shortestLine.length; ++i){

      // Check if the function is "addable" meaning if this artists row has time for 
      // The addition of this customer.


      boolean isAddable = shortestLine[i] == null && lessThan8Hours;
      if(isAddable){
        // If there is a spot open, add the customer to the two d array
        // and break out of the for loop to prevent overwriting data.
        shortestLine[i] = c;
        returnFlag = true;
        break;
      }
    }

    return returnFlag;
  }

  /**
   * This method returns the array of the artist's line with the shortest wait.
   * @author Luke Pfeiffer
   * @params TattooCustomer[][]
   */
  public static TattooCustomer[] minimumWait(TattooCustomer[][] customers){
    // Initialize variables. Min index is the index of the artist array the method will return.
    // standingMin is set to such a large number to ensure it gets overwritten.
    int minIndex = 0;
    int standingMin = Integer.MAX_VALUE;
    int length = customers.length;
    int [] waitTimes = new int[length];

    // currentMin is the wait time of the customers[][] at the index of the loop.
    // If currentMin is less than the standingMin (the last minimum value of the array)
    // then standingMin becomes currentMin and the minIndex is updated to the current
    // looping index.

    for(int i = 0; i < length; ++i){
      int currentMin = computeMinutesOfWork(customers[i]);

      if(currentMin < standingMin){
        standingMin = currentMin;
        minIndex = i;
      }
    }
    return customers[minIndex];
  }
}
