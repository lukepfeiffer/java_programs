import java.util.*;
import java.io.*;

public class BinarySearch{
  public static void main(String args[]){

    boolean flag = true;
    int randomInt = (int) (Math.random() * 300 + 1);
    int [] array = new int[300];
    int max = 300;
    int min = 1;
    int numGuesses = 0;

    for(int i = 0; i < array.length; ++i){
      array[i] = i + 1;
    }

    while(flag){
      int compGuess = (max + min) / 2;
      ++numGuesses;
      if( compGuess < randomInt){
        min = compGuess + 1;
      } else if( compGuess > randomInt){
        max = compGuess - 1;
      } else if(compGuess == randomInt){
        flag = false;
      }
    }

    System.out.println("The random number was: " + randomInt);
    System.out.println("The number of guesses was: " + numGuesses);
  }
}
