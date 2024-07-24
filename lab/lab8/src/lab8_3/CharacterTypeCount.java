package lab8_3;

// Fig. 16.17: WordTypeCount.java
// Program counts the number of occurrences of each word in a String.

import java.util.*;

public class CharacterTypeCount {
   public static void main(String[] args) {
      // create HashMap to store String keys and Integer values
      Map<Character, Integer> myMap = new HashMap<>();

      createMap(myMap); // create map based on user input
      displayMap(myMap); // display map content
   } 

   // create map from user input
   private static void createMap(Map<Character, Integer> map) {
      Scanner scanner = new Scanner(System.in); // create scanner
      System.out.println("Enter a string:"); // prompt for user input
      String input = scanner.nextLine();

      for(int i = 0; i < input.length(); i++){
         if(map.containsKey(input.charAt(i))){
            int count = map.get(input.charAt(i));
            map.put(input.charAt(i), count+1);
         } else if (input.charAt(i) != ' '){
            map.put(input.charAt(i), 1);
         }
      }
   } 
   
   // display map content
   private static void displayMap(Map<Character, Integer> map) {
      Set<Character> keys = map.keySet(); // get keys

      // sort keys
      TreeSet<Character> sortedKeys = new TreeSet<>(keys);

      System.out.printf("%nMap contains:%nKey\t\tValue%n");

      // generate output for each key in map
      for (Character key : sortedKeys) {
         System.out.printf("%-10s%10s%n", key, map.get(key));
      }
      
      System.out.printf(
         "%nsize: %d%nisEmpty: %b%n", map.size(), map.isEmpty());
   } 
} 


/**************************************************************************
 * (C) Copyright 1992-2018 by Deitel & Associates, Inc. and               *
 * Pearson Education, Inc. All Rights Reserved.                           *
 *                                                                        *
 * DISCLAIMER: The authors and publisher of this book have used their     *
 * best efforts in preparing the book. These efforts include the          *
 * development, research, and testing of the theories and programs        *
 * to determine their effectiveness. The authors and publisher make       *
 * no warranty of any kind, expressed or implied, with regard to these    *
 * programs or to the documentation contained in these books. The authors *
 * and publisher shall not be liable in any event for incidental or       *
 * consequential damages in connection with, or arising out of, the       *
 * furnishing, performance, or use of these programs.                     *
 *************************************************************************/
