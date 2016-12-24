import java.util.*;
import java.io.*;

class MaxValue {
  public static void main(String args[]){
    Stack<Integer> myStack = new Stack<Integer>();
    int rows = 10;
    int columns = 2;
    int array[][] = new int[rows][columns];
    int maxValue = Integer.MIN_VALUE;

    for(int i = 0; i < rows; ++i){
      for(int j = 0; j < columns; ++j){
        if(j < 1){
          array[i][j] = ((int)(Math.random()*2 + 1));
        } else{
          array[i][j] = ((int)(Math.random()*100 + 1));
        }
      }
    }

    for(int i = 0; i<rows; ++i){
      for(int j = 0; j<columns; j++){
        System.out.print(array[i][j] + " ");
      }
      System.out.println();
    }

    System.out.print("Sneak peek of the stack: ");

    for(int i = 0; i < rows; ++i){
      for(int j = 0; j < columns; ++j){
        if(j == 0){
          if(array[i][j] == 1){
            myStack.push(array[i][j+1]);
            if(array[i][j+1] > maxValue){
              maxValue = array[i][j+1];
            }
          } else if(array[i][j] == 2){
            if(myStack.size() != 0){
              System.out.print(myStack.peek() + " ");
            }
          }
        }
      }
    }

    System.out.println();
    System.out.println("The Stack: " + myStack);
    System.out.println("Max stack value: " + maxValue);

  }
}
