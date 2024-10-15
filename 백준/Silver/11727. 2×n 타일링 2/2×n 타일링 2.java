import java.util.*;
import java.io.*;

class Main{
    
    static int n;

    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
           
         if(n == 1){
            System.out.print(1);
            return;
        }
        
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 3;
        for(int i = 3; i < n+1; i++){
            dp[i] = ((dp[i - 2] * 2) + dp[i - 1]) % 10007;
        }

        System.out.print(dp[n]);
    }
}