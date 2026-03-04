import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        String A = sc.next();
        
        /* 
           1. Create a StringBuilder with string A
           2. Reverse it
           3. Convert it back to a String
        */
        String reversed = new StringBuilder(A).reverse().toString();
        
        /* 
           Compare the original string A with the reversed string.
           If they are equal, it's a palindrome.
        */
        if (A.equals(reversed)) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
        
    }
}
