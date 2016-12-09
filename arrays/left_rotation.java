import java.util.*;
import java.io.*;

class LeftRotation{
  public static void main(String args[]){
    System.out.println("Enter five numbers:");
    Scanner input = new Scanner(System.in);
    int length = 5;
    int rotationAmount = 3;
    int[] array = new int[length];
    int[] originalArray = new int[rotationAmount];

    for(int i = 0; i < length; ++i){
      if (i - rotationAmount < 0){
        array[i] = input.nextInt();
        originalArray[i] = array[i];
      } else {
        array[i] = input.nextInt();
      }
    }

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
