import java.util.*;
import java.io.*;

class StairCase{
  public static void main(String args[]){
    Scanner input = new Scanner(System.in);
    int length = 6;
    String stairs = "#";
    String white_space = " ";
    int white_space_length = length - 1;
    int stair_case_length = 1;
    for(int i = 0; i < length; ++i) {
      System.out.println(String.join("", Collections.nCopies(white_space_length, white_space)) + String.join("", Collections.nCopies(stair_case_length, stairs)));
      white_space_length = white_space_length - 1;
      stair_case_length = stair_case_length + 1;
    }
  }
}
