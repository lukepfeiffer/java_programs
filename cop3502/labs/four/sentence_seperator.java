import java.util.*;
import java.io.*;

class SentenceSeperator{
  public static void main(String args[]){
    Scanner input = new Scanner(System.in);
    System.out.println("Enter your sentence");
    String userInput = input.nextLine();
    int length = userInput.length();
    String word = " ";
    for(int i = 0; i < length; ++i){
      if (userInput.charAt(i) != ' '){
        word += userInput.charAt(i);
        if (i == length - 1) {
          System.out.println(word);
        }
      } else {
        System.out.println(word);
        word = " ";
      }
    }
  }
}
