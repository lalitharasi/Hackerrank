import java.util.Scanner;

public class Solution {

static boolean isAnagram(String a, String b) {
        // If lengths are different, they cannot be anagrams
        if (a.length() != b.length()) {
            return false;
        }

        // Convert both strings to lowercase to ensure case-insensitivity
        a = a.toLowerCase();
        b = b.toLowerCase();

        // Create an array to store the frequency of each character (a-z)
        int[] frequencies = new int[26];

        // Iterate through the strings
        for (int i = 0; i < a.length(); i++) {
            // Increment frequency for character in string 'a'
            frequencies[a.charAt(i) - 'a']++;
            // Decrement frequency for character in string 'b'
            frequencies[b.charAt(i) - 'a']--;
        }

        // If the strings are anagrams, every element in the frequency array must be 0
        for (int count : frequencies) {
            if (count != 0) {
                return false;
            }
        }

        return true;
    }

  public static void main(String[] args) {
    
        Scanner scan = new Scanner(System.in);
        String a = scan.next();
        String b = scan.next();
        scan.close();
        boolean ret = isAnagram(a, b);
        System.out.println( (ret) ? "Anagrams" : "Not Anagrams" );
    }
}

