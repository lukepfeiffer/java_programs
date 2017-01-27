import java.util.*;
import java.io.*;

class sandBox{
  public static void main(String args[]){
    Scanner input = new Scanner(System.in);
    System.out.println("Do a string boi: ");
    String stringOne = input.nextLine();
    String stringTwo = input.nextLine();
    if (stringOne.substring(0, 2).equals(stringTwo.substring(0,2))) {
      System.out.println("True");
    }
  }
}
