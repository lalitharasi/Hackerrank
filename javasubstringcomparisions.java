import java.util.Scanner;

public class Solution {

public static String getSmallestAndLargest(String s, int k) {
        // Initialize smallest and largest with the first possible substring
        String smallest = s.substring(0, k);
        String largest = s.substring(0, k);
        
        // Iterate through the string to find all substrings of length k
        // The loop runs until 's.length() - k' to ensure we don't go out of bounds
        for (int i = 1; i <= s.length() - k; i++) {
            String current = s.substring(i, i + k);
            
            // compareTo returns a negative integer if current is lexicographically smaller
            if (current.compareTo(smallest) < 0) {
                smallest = current;
            }
            
            // compareTo returns a positive integer if current is lexicographically larger
            if (current.compareTo(largest) > 0) {
                largest = current;
            }
        }
        
        return smallest + "\n" + largest;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.next();
        int k = scan.nextInt();
        scan.close();
      
        System.out.println(getSmallestAndLargest(s, k));
    }
}
