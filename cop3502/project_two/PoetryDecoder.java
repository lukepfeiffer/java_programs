import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.util.Scanner;

/*
 @author Luke Pfeiffer / 43634185
 COP 3502 Section Number: 128H
*/

public class PoetryDecoder {
  /*
    This main method asks the user to enter input. Then, it calls
    the decode method on that input. 
  */

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    //This prompt to the user is intentionally vague to avoid
    //incrimating those who use this program.
    System.out.println("Please enter your input: ");
    String hex = sc.nextLine();

    //STUDENTS: Your decode method must return a fully formatted String,
    //which will be output here. 
    System.out.print(decode(hex));

    sc.close();
  }

  /*
    This method returns the hex strings as actual letters using the toEnglishCharacters method call
    Then it goes through and finds all the reals words of length 4, 5, and 6 from the toEnglishCharacters string
    Finally, the method returns a nice and formatted string using the formatPoem method
  */
  public static String decode(String hex) {
	// This is the string that will be returned by the decode method
    String characterString = toEnglishLetters(hex); 
    
    
    String [] fourCharacterWords = findWordsOfLength(characterString, 4);
    String [] fiveCharacterWords = findWordsOfLength(characterString, 5);
    String [] sixCharacterWords = findWordsOfLength(characterString, 6);

    return formatPoem(fourCharacterWords, fiveCharacterWords, sixCharacterWords);
  }
 
  // Converts the string passed into it to readable english letters
  
  public static String toEnglishLetters(String hex){
	  
	// Initialize blank values
    int i = 0;
    String englishCharacters = "";
    
    // The loop continues while i is 1 less than the length to prevent an out of bounds exception for strings of odd length
    while(i < hex.length() - 1){
    	
      // Creates an substring from index of i to  i + 2 inclusive.
      // The letter at i and i + 1 is what is actually returned
      String tempString = hex.substring(i, i + 2);
  
	  // This total is used for adding the hex values together to get a ascii value
      int asciiValue = 0;
    	
	  // This variable is used to dynamically convert the hex
	  // The end of the loop decrements the exponent value so in our case the first value is "something" * 16 to the first
	  // and the second value "something" * 16 to the zeroth power
	  int exponent = 1;
	  
      for(int j = 0; j < tempString.length(); ++j){    		
       	// This switch statement checks the value at the charAt(j) and determines what corresponding base 10 value it should be
    	    switch(tempString.charAt(j)){
    	      case 'a':
    	      	// The exponent variable is dynamic based on the above explanation
    	       	asciiValue += (10 * (Math.pow(16, exponent)));
    	       	break;
    	      case 'A':
            	asciiValue += 10 * (Math.pow(16, exponent));
   	        	break;
   	          case 'b':
   	        	asciiValue += 11 * (Math.pow(16, exponent));
    	         	break;
    	      case 'B':
    	       	asciiValue += 11 * (Math.pow(16, exponent));
    	       	break;
    	      case 'c':
    	       	asciiValue += 12 * (Math.pow(16, exponent));
    	       	break;
              case 'C':
            	asciiValue += 12 * (Math.pow(16, exponent));
   	        	break;
   	          case 'd':
    	        asciiValue += 13 * (Math.pow(16, exponent));
    	       	break;
    	      case 'D':
    	       	asciiValue += 13 * (Math.pow(16, exponent));
    	       	break;
    	      case 'e':
    	       	asciiValue += 14 * (Math.pow(16, exponent));
    	       	break;
    	      case 'E':
    	       	asciiValue += 14 * (Math.pow(16, exponent));
    	       	break;
    	      case 'f':
    	       	asciiValue += 15 * (Math.pow(16, exponent));
            	break;
   	          case 'F':
   	        	asciiValue += 15 * (Math.pow(16, exponent));
   	        	break;
   	          default:
   	        	// If the value of the character is a normal integer, return that integer
   	            asciiValue +=  Character.getNumericValue(tempString.charAt(j))* (Math.pow(16, exponent));   
    	  }
    	// Decrement the exponent to adhere to the above comments
    	--exponent;   
      }
      if(asciiValue >= 65 && asciiValue <= 90){
	    englishCharacters += (char) asciiValue;
	  } else if ( asciiValue >= 97 && asciiValue <= 122 ) {
	    englishCharacters += (char) asciiValue;
	  } else {
		// This is used to set values outside of the normal ascii letter intervals. Since we are saying that if
		// asciiValue % 26 = 0 then the character should be 'a', then we simply add 65 to the modded value
		// to get a valid character
		englishCharacters += (char) (asciiValue%26 + 65);
	  }
    	// Sets i to a the index after the two hex values we have read
    	// Prevents the same hex value from being read twice
      i += 2;
    }
    return englishCharacters;
  }


  /*
    This method searches an input String of English letters, and returns all words of 
    the specified length that occur in the String. A "sliding window" will be considered, so 
    a given character could occur in more than one word that is found. This is desirable.
  */
  public static String[] findWordsOfLength(String letters, int wordSize) {
	// A little strange but this ensures that no matter the size of the string
	// The resulting array using this wordSize will never be negative
	int indexSubtractor = 0;
    if(wordSize > letters.length()){
      indexSubtractor  = 1;
    } else {
      indexSubtractor = wordSize;
    }
    
	// Initialize the array that the method will return. The length is set by grabbing the length of
	// string we pass the method and subtracting the indexSubtractor (which is dynamically set) + 1. For example, a string of length
	// 6 and an indexSubtractor of 5 will have an array size of 2
	String [] stringArray = new String[letters.length()-(indexSubtractor-1)];
	
	// Check if the length of the string passed is bigger than the wordSize we are checking for. If not
	// then nothing will happen
	if(letters.length() >= wordSize){
	
      
      // This variable will be used to get the right index for the cases when a word valid word is not returned
      int j = 0;
      
      // Populate string array with valid words
      for(int i = 0; i < stringArray.length; ++i){
        String tempString = letters.substring(i, i + wordSize);
        
        // If word is a real word, add it to the string array
        if(isWord(tempString)){
       	  stringArray[j] = tempString;
          ++j;
        }
      }
      
      // Using that handy "j" variable, we can remember where we left off from the other for loop and populate
      // the rest of the values that may not have been filled with a valid word in the array

      
    // If the length of the string passed is not big enough, set the stringArray to null
	} else {
	  stringArray = new String[1];
	}
	
    return stringArray;
  }

  // This method finds the number of values within the array that are not null
  public static int notNullCount(String array[]){
	  int validCounter = 0;
	  
	  // Loop through the array until the value returned is null
	  while( validCounter < array.length && array[validCounter] != null){  
		++validCounter;
	  }
	  
	  return validCounter;
  }
  
  // This method formats the poem into a nice and formatted string
  public static String formatPoem(String[] shortest, String[] medium, String[] longest){
	// This is the string that will be returned
	String tempString = "";
	
	// These will be used to grab the max length that the for loop will go for
	// and also ensure that we do not go out of bounds for the loops
	int shortArrayLength = notNullCount(shortest);
	int mediumArrayLength = notNullCount(medium);
	int longArrayLength = notNullCount(longest);;
	
	int maxLength = Math.max(Math.max(shortArrayLength, mediumArrayLength), longArrayLength);
	int tabCounter = 0;
	for(int i = 0; i < maxLength; ++i){
		
		
		// Add a new line for everyone iteration of the "i" loop
        tempString += "\n";
        
		// Add an indentation equal to the number of lines we are on, starting at 0;
		for(int j = 0; j < tabCounter; ++j){
			tempString += "\t";
		}
		
		// Check to make sure we do not go out of bounds for the longest word array
		if( i < longArrayLength){
	      // Make sure a null value is not passed to the string
		  // Add the longest array at index of i to the return string
		  if(longest[i] != null){
		    tempString += (longest[i] + " ");
		  }
		}
		
		// Check to make sure we do not go out of bounds for the medium word array
		if( i < mediumArrayLength){	
		  // Make sure we do not push a null value to string
		  // Add the medium array at index of i to the return string
		  if(medium[i] != null){
		    tempString += (medium[i] + " ");
		  }
		}
		
		// Check to make sure we do not go out of bounds for the shortest word array
		if( i < shortArrayLength){
		  // Make sure we do not push a null value to the string
		  // Add the shortest array at index of i to the return string
		  if( shortest[i] != null){
		    tempString += shortest[i];
		  }
		}
		
		// Increment the tab counter so every time we iterate we can properly format the poem with the correct amount
		// of tabs
		++tabCounter;
	}
    return tempString;	
  }



	/* *******************************************************************************
	STUDENTS -- BELOW THIS POINT ARE METHODS PROVIDED FOR YOU. DO NOT EDIT THEM. 
	USE THEM AS INDICATED IN THEIR DESCRIPTIONS. 
	 ********************************************************************************/

	/**
	 * This method checks whether the given String occurs in a dictionary of English.
	 * STUDENTS: DO NOT MODIFY THIS METHOD IN ANY WAY. IT IS PROVIDED FOR YOU. 
	 * This method will terminate your program if it is unable to access the remote URL.
	 * You must be online for this code to work. 
	 * @param possWord The word to be checked.
	 * @return boolean Returns true if the word given is an English word, false otherwise.
	 */
	private static boolean isWord(String possWord) {
		boolean isWord = true;
		try {
			//connect to the URL. 
			String s = getUrl(possWord);
			Document d = Jsoup.connect(s).timeout(6000).get();
			Elements tdTags = d.select("h3");

			// Loop over all tdTags, in this case: the h3 tag 
			for( Element element : tdTags ){
				String check = element.toString();

				//Wordnet has a special h3 tag that appears only if the word is not in the dictionary
				//We search for this tag. If it is found, then the word searched is not in the dictionary
				if(check.equals("<h3>Your search did not return any results.</h3>") ){
					isWord = false;
				}
			}
		}
		catch (IOException e) {
			System.err.print("CHECK INTERNET CONNECTION. Could not connect to jsoup URL.");
			System.exit(0);
		}
		return isWord;
	}

/**
	 * This is a helper method that the teaching staff code uses. 
	 * STUDENTS: DO NOT EDIT THIS METHOD.
	 * This method will terminate your program if it is unable to access the remote URL.
	 * You must be online for this code to work. 
	 * @param String: search 
	 * @return A string containing the URL for the wordnet search.
	 */
	private static String getUrl(String search) {
		//Standard URL for wordnet to search
		String url = "http://wordnetweb.princeton.edu/perl/webwn?s=";
		String newURL = null;
		try {
			//Get new page from word wordnet and get its location
			Document doc = Jsoup.connect(url + search).timeout(6000).get();
			newURL = doc.location().toString();
		}
		catch (IOException e) {
			System.err.print("CHECK INTERNET CONNECTION. Could not connect to jsoup URL.");
			System.exit(0);
		}
		//Return the string of the new URL. 
		return (newURL);
	}

}