import java.util.*;
import java.io.*;
class ReverseArray{
  public static void main(String args[]){
    System.out.println("Input your number and press enter: ");
    Scanner input = new Scanner(System.in);
    int length = 4;
    int values[] = new int[length];

    for(int i = 0; i < length; ++i) { values[i] = input.nextInt(); }
    for(int i = length - 1; i >= 0; --i) { System.out.print(values[i] + " "); }
  }
}
