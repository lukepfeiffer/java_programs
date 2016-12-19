import java.util.*;
import java.io.*;

class TwoDimensional {
  public static void main(String args[]){
    int rows = 6;
    int columns = 6;
    int[][] values = new int[rows][columns];
    int sum = 0;

    for(int i = 0; i < rows; ++i){

      for(int j = 0; j < columns; ++j){
        values[i][j] = ((int)(Math.random()*100 + 1));
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
