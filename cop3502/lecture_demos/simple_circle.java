import java.util.*;
import java.io.*;

class SimpleCircle{
  // This is a member variable. Defines the state of the object.
  double radius;


  // This is the constructor. It will ALWAYS be public
  // Will NEVER have a return type.
  // And is named after the class of the file.

  public SimpleCircle(double radius){
    // "this" refers to the object and "this.radius" refers to this
    // objects radius. Set it to whatever is passed into the constructor
    this.radius = radius;
  }

  public double getArea(){
    // Radius automatically refers to the closest "radius" variable in scope.
    return (radius * radius * Math.PI);
  }

}
