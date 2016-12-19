import java.util.*;
import java.io.*;

class BubbleSort {
  public static void main(String args[]){
    int tmp;
    int j = 0;
    int length = 15;
    boolean swapped = true;
    int[] array = new int[length];

    System.out.print("Original array: ");

    for(int i = 0; i < length; ++i){
      array[i] = ((int)(Math.random()*100 + 1));
      System.out.print(array[i] + " ");
    }

    System.out.println();
    System.out.print("Newly sorted array: ");

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
