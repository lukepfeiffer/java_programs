import java.util.*;
import java.io.*;

class TwoDimensional {
  public static void main(String args[]){
    System.out.println("Enter some values");
    Scanner input = new Scanner(System.in);
    int rows = 2;
    int columns = 2;
    int[][] values = new int[rows][columns];
    int sum = 0;

    for(int i = 0; i < rows; ++i){

      for(int j = 0; j < columns; ++j){
        values[i][j] = input.nextInt();
      }

    }

    for(int i = 0; i<rows; i++){

      for(int j = 0; j<columns; j++){
        System.out.print(values[i][j] + " ");
      }

      System.out.println();
    }


  }
}
