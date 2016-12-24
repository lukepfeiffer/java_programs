import java.util.*;
import java.io.*;

class CardGame {
  public static void main(String args[]){
    System.out.println("The deck consists of 30 cards with a random number of cards ranging from 1-15");
    System.out.println("The goal is to have a sum as close to 30 as possible");
    System.out.println("Player One's turn! How many cards do you want to pick up? (2-4 suggested)");
    Scanner playerOne = new Scanner(System.in);
    Stack<Integer> deck = new Stack<Integer>();
    int deckSize = 26;
    int lengthOne = playerOne.nextInt();
    if(lengthOne > 10) {
      lengthOne = 10;
    }
    int playerOneSum = 0;
    int playerTwoSum = 0;
    int targetSum = 30;

    for(int i = 0; i < deckSize; ++i){
      deck.push(((int)(Math.random()*15 + 1)));
    }


    for(int i = 0; i < lengthOne; ++i){
      playerOneSum = playerOneSum + deck.peek();
      deck.pop();
    }

    System.out.println("Player one sum: " + playerOneSum);

    if(playerOneSum < 30){
      System.out.println("Press 1 to continue, anything else will be a no");
      Scanner playerOneContinue = new Scanner(System.in);

      if(playerOneContinue.nextInt() == 1){
        Scanner playerOneRedo = new Scanner(System.in);
        System.out.println("Pick another set of cards (no more than 3)");
        int secondHand = playerOneRedo.nextInt();

        if(secondHand > 3){
          secondHand = 3;
        }

        for(int i = 0; i < secondHand; ++i){
          playerOneSum = playerOneSum + deck.peek();
          deck.pop();
        }
      }
      System.out.println("Player 1 final sum: " + playerOneSum);
    }

    System.out.println("Player Two's turn! How many cards do you want to pick up? (2-4 suggested)");
    Scanner playerTwo = new Scanner(System.in);
    int lengthTwo = playerTwo.nextInt();
    if(lengthTwo > 10) {
      lengthTwo = 10;
    }

    for(int i = 0; i < lengthTwo; ++i){
      playerTwoSum = playerTwoSum + deck.peek();
      deck.pop();
    }

    System.out.println("Player Two sum: " + playerTwoSum);

    if(playerTwoSum < 30){
      System.out.println("Press 1 to continue, anything else will be a no");
      Scanner playerOneContinue = new Scanner(System.in);

      if(playerOneContinue.nextInt() == 1){
        Scanner playerTwoRedo = new Scanner(System.in);
        System.out.println("Pick another set of cards (no more than 3)");
        int secondHand = playerTwoRedo.nextInt();

        if(secondHand > 3){
          secondHand = 3;
        }

        for(int i = 0; i < secondHand; ++i){
          playerTwoSum = playerTwoSum + deck.peek();
          deck.pop();
        }
      }
      System.out.println("Player 2 final sum: " + playerTwoSum);
    }
    if(Math.abs(playerOneSum - targetSum) < Math.abs(playerTwoSum - targetSum)) {
      System.out.println("Player One Wins!!!");
    } else if(Math.abs(playerOneSum - targetSum) == Math.abs(playerTwoSum - targetSum)) {
      System.out.println("Tie game!!!");
    } else{
      System.out.println("Player Two Wins!!!");
    }
  }
}
