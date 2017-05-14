import java.util.*;
import java.io.*;

public class ImplementBinarySearch{
  public static void main(String args[]){
    int [] primes = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97};
    int index = doSearch(primes, 8);
    if(index == -1){
      System.out.println("The target value was not inside the array.");
    } else{
      System.out.println("Found the target value at index of: " + index);
    }
  }

  /* Returns the index of the target value!
   * @param int[] array, int targetValue
   * @author Luke Pfeiffer
   */
  public static int doSearch(int[] array, int target){
    int min = 0;
    int max = array.length - 1;
    int index = -1;
    boolean flag = true;
    int n = 0;

    while(flag){
      int midPoint = (max + min) / 2;
      int compGuess = array[midPoint];

      if(max < min){
        // If the max is less than min, the value we are searching for is invalid. Stop the while loop
        // and set the return index to -1.
        flag = false;
        index = -1;

      } else if(compGuess > target){
        // If the guessed values is to large, set the max value to midPoint - 1
        max = midPoint - 1;

      } else if(compGuess < target) {
        // If the guessed value is to small, set the min value to the midPoint + 1
        min =  midPoint + 1;

      } else if(compGuess == target){
        // If the computer finds the target, then stop the while loop and set return index to the index of
        // the array at that point.
        flag = false;
        index = midPoint;
      }
    }

    return index;
  }
}
