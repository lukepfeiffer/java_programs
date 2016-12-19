import java.util.*;
import java.io.*;

class RightRotation{
  public static void main(String args[]){
    System.out.println("Enter five numbers:");
    Scanner input = new Scanner(System.in);
    int length = 5;
    int rotationAmount = 3;
    int[] array = new int[length];
    int[] originalArray = new int[length];

    for(int i = 0; i < length;  ++i){
      array[i] = input.nextInt();
      originalArray[i] = array[i];
    }

    for(int i = 0; i < length; ++i){
      array[i] = originalArray[(i+rotationAmount)%length];
      System.out.print(array[i] + " ");
    }
  }
}
