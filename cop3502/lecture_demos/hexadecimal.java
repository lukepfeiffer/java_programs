import java.util.*;
import java.io.*;

class Hexadecimal{
  public static void main(String args[]){
    Scanner scan = new Scanner(System.in);
    boolean isValid = true;
    String hex;
    int decOutput = 0;

    do {
      System.out.println("Enter a valid hexadecimal");
      hex = scan.next();

      for(int i = 0; i < hex.length(); i++) {
        String validCharacters = "0123456789ABCDEF";
        if(validCharacters.indexOf(hex.charAt(i)) == -1){
          isValid = false;
        } else {
          isValid = true;
        }
      }

    } while (!isValid);

    System.out.println("Valid Stuff");

  }
}
