import java.util.*;
import java.io.*;

class SandBox{
  public static void main(String[] args){
    Dog dog = new Dog();
    Boxer boxer = new Boxer();
    dog = (Dog)((Animal)boxer);
    System.out.println(dog instanceof Boxer);
  }
}

class Animal {
  void eat(){
    System.out.println("Animal is eating");
  }
}

class Dog extends Animal{
  void eat(){
    System.out.println("Dog is eating");
  }
}

class Boxer extends Dog{
  void eat(){
    System.out.println("Boxer is eating");
  }
}
