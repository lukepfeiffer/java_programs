import java.util.*;
import java.io.*;

class InsertionSort{

  // Descending Sort!!!

  public static void main(String args[]){
    int key;
    int j;
    int i;
    int length = 15;
    int[] array = new int[length];

    System.out.print("Original array: ");

    for(i = 0; i < length; ++i){
      array[i] = ((int)(Math.random()*100 + 1));
      System.out.print(array[i] + " ");
    }

    System.out.println();
    System.out.print("Newly sorted array: ");

    for (j = 1; j < length; ++j) {
      key = array[j];

      for(i = j - 1; (i >= 0) && (array[i] < key); --i) {
        array[i+1] = array[i];
      }
      array[i+1] = key;
    }

    for(i = 0; i < length; ++i){
      System.out.print(array[i] + " ");
    }
  }
}
