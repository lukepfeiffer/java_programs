import java.util.*;
class LinkedList{

  private Node head = null;

  public void append(int value){
    Node lastNode = getLastNode();
    if(lastNode == null){
      head = new Node(value);
    } else {
      lastNode.next = new Node(value);
    }
  }

  public void delete(int value){
    if(head == null){
      return;
    }

    Node previousNode = null;
    Node currentNode = head;

    while(currentNode != null && currentNode.number != value){
      previousNode = currentNode;
      currentNode = currentNode.next;
    }

    if(previousNode == null){
      head = head.next;
      return;
    }

    if(currentNode == null){
      System.out.println("A node with that value does not exist.");
      return;
    }
    previousNode.next = currentNode.next;
  }

  public void print(){
    if(head == null){
      System.out.print("EMPTY");
      return;
    }

    Node tmpNode = head;

    while (tmpNode != null) {
      System.out.print(tmpNode.number + " -> ");
      tmpNode = tmpNode.next;
    }

  }

  private Node getLastNode(){
    if(head == null){
      return null;
    }

    Node tmpNode = head;
    while(tmpNode != null){
      tmpNode = tmpNode.next;
    }
    return tmpNode;
  }

  public static void main(String[] args) {
    System.out.println("Add some values");
    LinkedList myList = new LinkedList();
    Scanner input = new Scanner(System.in);

    myList.append(input.nextInt());
    myList.print();
    System.out.println("");
  }
}
