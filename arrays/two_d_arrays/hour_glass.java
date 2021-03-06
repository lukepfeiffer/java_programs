import java.util.*;
import java.io.*;

class HourGlass{
  public static void main(String args[]){
    int rows = 6;
    int columns = 6;
    int[][] array = new int[rows][columns];
    int temp_sum = 0;
    int sum = Integer.MIN_VALUE;

    // set values
    for (int i = 0; i < rows; ++i) {
      for (int j = 0; j < columns; ++j){
        array[i][j] = ((int)(Math.random()*100 + 1));
      }
    }

    // print values
    for(int i = 0; i < rows; i++){
      for(int j = 0; j < columns; j++){
        System.out.print(array[i][j] + " ");
      }
      System.out.println();
    }

    // print largest sum
    for(int i = 0; i < rows - 2; ++i){
      for(int j = 0; j < columns - 2; ++j){
        temp_sum = array[i][j] + array[i][j+1] + array[i][j+2] + array[i+1][j+1] + array[i+2][j] + array[i+2][j+1] + array[i+2][j+2];
        if(sum < temp_sum){ sum = temp_sum; }
      }
    }

    System.out.println("Largest hourglass sum: " + sum);

  }
}
