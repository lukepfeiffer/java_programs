import java.util.*;
import java.io.*;

public class InsertionSort{
  public static void main(String args[]){

    Scanner scan = new Scanner(System.in);
    boolean flag = true;
    int i = 0;

    // Populate the array
    int arraySize = 30;
    int [] array = populateArray(arraySize);


    printArray(array);

    while(flag && i < 30){
      System.out.println("Continue? Yes/No");
      if(scan.next().compareToIgnoreCase("No") == 0){
        flag = false;
      } else {
        System.out.println("Enter an integer");
        int userInput = scan.nextInt();
        insertInt(array, userInput);
      }
      printArray(array);
      ++i;
    }

  }

  public static void insertInt(int [] array, int input){
    for(int i = 0; i < array.length; ++i){
      if(input < array[i]){
        shiftArray(array, i);
        array[i] = input;
        break;
      }
    }
  }

  public static void shiftArray(int [] array, int finalIndex){
    for(int i = array.length - 2; i >= finalIndex; --i){
      array[i+1] = array[i];
    }
  }

  public static int[] populateArray(int size){
    int array [] = new int[size];
    int i = 0;

    for(i = 0; i < (size/2); ++i){
      array[i] = i + 1;
    }

    for(int k = i; k < size; ++k){
      array[k] = Integer.MAX_VALUE;
    }

    return array;
  }

  public static void printArray(int[] array){

    System.out.println("The array is now: ");

    for(int i = 0; i < array.length; ++i){
      if(array[i] > Integer.MAX_VALUE - 1){
      } else {
        System.out.print(array[i] + " ");
      }
    }

    System.out.println();
  }
}
