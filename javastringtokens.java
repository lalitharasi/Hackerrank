import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        // Handle empty input case
        if (!scan.hasNext()) {
            System.out.println(0);
            return;
        }
        
        String s = scan.nextLine();
        
        // 1. Trim leading and trailing whitespace.
        // This handles inputs that are just spaces or have extra spaces at the ends.
        s = s.trim();
        
        // 2. Check if the string is empty after trimming.
        if (s.length() == 0) {
            System.out.println(0);
        } else {
            // 3. Split the string using a regular expression.
            // [^A-Za-z]+ matches one or more characters that are NOT English letters.
            String[] tokens = s.split("[^A-Za-z]+");
            
            // 4. Handle the "leading delimiter" edge case.
            // If the string starts with a non-letter (e.g., "!Hello"), 
            // split() will put an empty string at the 0th index of the array.
            int start = 0;
            if (tokens.length > 0 && tokens[0].isEmpty()) {
                start = 1;
            }
            
            // 5. Print the total count of valid tokens.
            System.out.println(tokens.length - start);
            
            // 6. Print each token on a new line.
            for (int i = start; i < tokens.length; i++) {
                System.out.println(tokens[i]);
            }
        }
        
        scan.close();
    }
}
