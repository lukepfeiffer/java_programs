import java.util.*;
import java.io.*;

class LeftRotation{
  public static void main(String args[]){
    System.out.println("Enter five numbers:");
    int length = (int)((Math.random() * 12) + 3);
    int rotationAmount = (int)(Math.random() * 5);
    int[] array = new int[length];
    int[] originalArray = new int[rotationAmount];

    System.out.println("The rotation amount is: " + rotationAmount);

    for(int i = 0; i < length; ++i){
      if (i - rotationAmount < 0){
        array[i] = i + 1;
        originalArray[i] = array[i];
      } else {
        array[i] = i + 1;
      }
      System.out.print(array[i] + " ");
    }

    System.out.println("");

    for(int i = 0; i < length; ++i){

      int edgeCase = i - (length - rotationAmount);

      if(i + rotationAmount >= length){
        array[i] = originalArray[edgeCase];
      } else {
        array[i] = array[i+rotationAmount];
      }
      System.out.print(array[i] + " ");
    }

  }
}
