import java.util.Scanner;

/*
  Name: Luke Pfeiffer
  ID: 4363-4185
  Section Number: 128H
  This is a program that ensures that drones equipped with cameras are not to close to one another.
  These drones are used to catch cats and dogs by surveying the neighborhood!
  This is to ensure they do not collide as well as make sure that their camera coverage does not overlap too much.
*/

class AutonomousDrones {
  public static void main(String args[]) {
    Scanner input = new Scanner(System.in);

    // User populates the coordinates for the first drone

    System.out.println("Please enter the x coordinate of Drone 1:");
    double droneOneXCoordinate = input.nextDouble();

    System.out.println("Please enter the y coordinate of Drone 1:");
    double droneOneYCoordinate = input.nextDouble();

    System.out.println("Please enter the altitude coordinate of Drone 1:");
    double droneOneAltitude = input.nextDouble();

    // User populates the coordinates for the second drone

    System.out.println("Please enter the x coordinate of Drone 2:");
    double droneTwoXCoordinate = input.nextDouble();

    System.out.println("Please enter the y coordinate of Drone 2:");
    double droneTwoYCoordinate = input.nextDouble();

    System.out.println("Please enter the altitude coordinate of Drone 2:");
    double droneTwoAltitude = input.nextDouble();

    // Storing the "squared" values as variables to improve readability of the final algorithm
    double xSquared = Math.pow((droneTwoXCoordinate - droneOneXCoordinate), 2);
    double ySquared = Math.pow((droneTwoYCoordinate - droneOneYCoordinate), 2);
    double altitudeSquared = Math.pow((droneTwoAltitude - droneOneAltitude), 2);

    // Calculate the distance between drones in two and three dimensions
    double twoDimensionalDistance = Math.pow((xSquared + ySquared),0.5);
    double threeDimensionalDistance = Math.pow((xSquared + ySquared + altitudeSquared), 0.5);

    /*
      Check if the drones are too close or not close enough in (x,y)
      If they are too close, the user is told they need to be farther
      If they are too far, the user is told they need to be closer
      If they are just right, the user is told they are just fine where they are
    */

    if (twoDimensionalDistance < 1) {
      System.out.println("The drones are " + twoDimensionalDistance + " feet apart in (x,y) coordinates. They need to move farther apart in (x,y).");
    } else if (twoDimensionalDistance > 500) {
      System.out.println("The drones are " + twoDimensionalDistance + " feet apart in (x,y) coordinates. They need to move closer together in (x,y).");
    } else {
      System.out.println("The drones are " + twoDimensionalDistance + " feet apart in (x,y) coordinates. They do not need to move farther apart or closer in (x,y).");
    }

    /*
       Check if the drones are too close or not close enough in (x,y) and altitude
       If they are too far, the user is told they need to be closer
       If they are just right, the user is told they are fine where they are
       If they are too close, the user is told they need to be farther
    */

    if (threeDimensionalDistance < 1) {
      System.out.println("The drones are " + threeDimensionalDistance + " feet apart in 3D space. They need to move farther apart.");
    } else if (threeDimensionalDistance > 500) {
      System.out.println("The drones are " + threeDimensionalDistance + " feet apart in 3D space. They need to move closer together.");
    } else {
      System.out.println("The drones are " + threeDimensionalDistance + " feet apart in 3D space. They do not need to move farther apart or closer.");
    }
  }
}
