import java.util.*;
import java.io.*;

class SandBox{
  public static void main(String[] args){
    array int [][] = new int[6][6];
    for(int i = 0; i < 6; ++i){
      for(int j = 0; j < 6; ++j){
        array[i][j] = (int) (Math.random()*10 + 1);
      }
    }

    for(int i = 0; i < 6; i++){

      for(int j = 0; j < 6; j++){
        System.out.print(values[i][j] + " ");
      }

      System.out.println();
    }
  }
  public static void InitWithNegOnes(int [][] twoDArray){
    int row = twoDArray.length;
    for(int i = 0; i < row; ++i){
      for(int j = 0; j < row[i].length; ++j){
        twoDArray[i][j] = -1;
      }
    }
  }
}
