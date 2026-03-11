import java.io.*;
import java.math.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String n = bufferedReader.readLine();
        
        // Initialize BigInteger with the input string
        BigInteger number = new BigInteger(n);
        
        // Use isProbablePrime(certainty)
        // A certainty of 100 provides a 1 - (1/2)^100 probability of being correct
        if (number.isProbablePrime(100)) {
            System.out.println("prime");
        } else {
            System.out.println("not prime");
        }

        bufferedReader.close();
    }
}
