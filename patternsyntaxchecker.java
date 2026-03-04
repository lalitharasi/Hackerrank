import java.util.Scanner;
import java.util.regex.*;

public class Solution
{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        // Read the number of test cases
        int testCases = Integer.parseInt(in.nextLine());
        
        while(testCases > 0){
            String pattern = in.nextLine();
            
            try {
                // Attempt to compile the pattern
                Pattern.compile(pattern);
                // If no exception is thrown, it is valid
                System.out.println("Valid");
            } catch (PatternSyntaxException e) {
                // If a PatternSyntaxException is caught, it is invalid
                System.out.println("Invalid");
            }
            
            testCases--;
        }
        in.close();
    }
}
