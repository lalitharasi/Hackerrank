import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution{
    public static void main(String[] args){
        
        Scanner in = new Scanner(System.in);
        int testCases = Integer.parseInt(in.nextLine());
        
        while(testCases > 0){
            String line = in.nextLine();
            
            // The regex to find valid tag-content-tag sequences
            String regex = "<([^<>]+)>([^<>]+)</\\1>";
            Pattern p = Pattern.compile(regex);
            Matcher m = p.matcher(line);
            
            boolean found = false;
            
            // find() looks for the next subsequence that matches the pattern
            while (m.find()) {
                // Group 2 contains the content inside the tags
                System.out.println(m.group(2));
                found = true;
            }
            
            if (!found) {
                System.out.println("None");
            }
            
            testCases--;
        }
        in.close();
    }
}
