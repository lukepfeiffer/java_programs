import java.util.*;
import java.io.*;

class BubbleSort {
  public static void main(String args[]){
    System.out.println("Enter five numbers");
    Scanner input = new Scanner(System.in);
    boolean swapped = true;
    int j = 0;
    int length = 5;
    int tmp;
    int[] array = new int[length];

    for(int i = 0; i < length; ++i){
      array[i] = input.nextInt();
    }

    while (swapped) {
      swapped = false;
      j++;
      for (int i = 0; i < array.length - j; ++i) {
        if (array[i] > array[i + 1]) {
          tmp = array[i];
          array[i] = array[i + 1];
          array[i + 1] = tmp;
          swapped = true;
        }
      }
    }

    for(int i = 0; i < length; ++i){
      System.out.print(array[i] + " ");
    }
  }
}
