import java.util.Scanner;

class Years{
  public static void main(String args[]){
    System.out.println("Enter number of years");
    Scanner input = new Scanner(System.in);
    int years = input.nextInt();
    int hours = years * 365 * 24;
    System.out.println("In " + years + " years there are " + hours);
    input.close();
  }
}
