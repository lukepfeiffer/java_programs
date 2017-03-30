import java.util.*;
import java.io.*;

class SandBox{
  public static void main(String[] args){
                String returnString = "";
		String meridian = "";
		if (22.0987 >= 12){
			meridian = "PM";
		} else {
			meridian = "AM";
		}
		double newTime = ((int)(22.0987 * 100)/100.0);
		String stringTime = Double.toString(newTime);
		String[] split = stringTime.split("\\.");
		String hour = split[0];
		String minutes = split[1];
		returnString = hour + ":" + minutes + " " + meridian;
		System.out.println(returnString);
  }
}
