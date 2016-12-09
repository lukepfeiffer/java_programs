import java.util.*;
import java.io.*;
class SumArray{
  public static void main(String args[]){
    System.out.println("Input your number and press enter: ");
    Scanner input = new Scanner(System.in);
    int length = 6;
    int[] values = new int[length];
    int sum = 0;

    for(int i = 0; i < length; ++i) {
      values[i] = input.nextInt();
      sum = sum + values[i];
      if(i == 5) {
        System.out.println(values[i]);
      }
      else{
        System.out.print(values[i] + " + ");
      }
    }
    System.out.println(sum);
  }
}
