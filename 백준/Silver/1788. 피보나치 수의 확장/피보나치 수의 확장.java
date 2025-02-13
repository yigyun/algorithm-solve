import java.util.*;
import java.io.*;

class Main{

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        if(n == 0){
            System.out.println(0);
            System.out.print(0);
            return;
        }
        int m = Math.abs(n);
        int[] dp = new int[m+1];

        dp[0] = 0; dp[1] = 1;
        for(int i = 2; i <= m; i++){
            dp[i] = (dp[i-1] + dp[i-2]) % 1000000000;
        }

        int op = 1;

        if(n < 0 && m % 2 == 0){
            op = -1;
        }

        System.out.println(op);
        System.out.print(dp[m]);
    }
}