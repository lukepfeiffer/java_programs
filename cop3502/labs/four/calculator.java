import java.util.*;
import java.io.*;

class Calculator{
  public static void main(String args[]){
    Scanner input = new Scanner(System.in);
    System.out.println("What number would you like to stop at?");
    double positiveEnd = input.nextInt();
    double negativeEnd = (positiveEnd * -1);
    System.out.println("What number would you like to start at?");
    double initial = input.nextInt();
    double secondNumber;
    double sum = initial;
    char operation;

    System.out.println(positiveEnd);
    while ( sum < positiveEnd && sum > negativeEnd) {
      System.out.println("What operation would you like to perform?");
      operation = input.next().charAt(0);
      System.out.println("Enter a new number");
      secondNumber = input.nextInt();
      if (operation == '+'){
        sum += secondNumber;
      } else if (operation == '-'){
        sum -= secondNumber;
      } else if (operation == '*'){
        sum *= secondNumber;
      } else if (operation == '/'){
        sum /= secondNumber;
      } else {
        System.out.println("Invalid input");
      }
      sum = Math.round(sum);
      System.out.println("New sum is " + sum);
    }
    System.out.println("The final sum is " + sum);
  }
}
