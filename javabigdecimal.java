import java.math.BigDecimal;
import java.util.*;
class Solution{
    public static void main(String []args){
        //Input
        Scanner sc= new Scanner(System.in);
        int n=sc.nextInt();
        String []s=new String[n+2];
        for(int i=0;i<n;i++){
            s[i]=sc.next();
        }
        sc.close();

// Write your code here
        Arrays.sort(s, 0, n, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                // Convert strings to BigDecimal to compare numerical values
                BigDecimal bdA = new BigDecimal(a);
                BigDecimal bdB = new BigDecimal(b);
                
                // For descending order, compare b to a
                return bdB.compareTo(bdA);
            }
        });
        //Output
        for(int i=0;i<n;i++)
        {
            System.out.println(s[i]);
        }
    }
}
