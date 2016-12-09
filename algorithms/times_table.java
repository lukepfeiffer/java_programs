import java.util.*;
import java.io.*;

class TimesTable{
  public static void main(String args[]){
    System.out.println("Enter the desired number:");
    Scanner input = new Scanner(System.in);
    int length = 12;
    int value = input.nextInt();
    int multiplier = 0;

    for(int i = 0; i <= length; ++i){
      System.out.println("  " + value + " x " + multiplier + " = " + (multiplier * value));
      multiplier = multiplier + 1;
    }
  }
}
