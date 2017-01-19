import java.util.Scanner;

class Minutes{
  public static void main(String args[]){
    System.out.println("Enter number of seconds");
    Scanner input = new Scanner(System.in);
    int seconds = input.nextInt();
    int minutes = seconds / 60;
    int remainingSeconds = seconds % 60;
    System.out.println("In " + seconds + " seconds there are " + minutes + " minute(s) and " + remainingSeconds + " second(s)");
  }
}
