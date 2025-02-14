import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        int n = str.length();

        if (n == 0 || str.charAt(0) == '0') {
            System.out.print(0);
            return;
        }

        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        for(int i = 2; i <= n; i++){
            int num1 = str.charAt(i-1) - '0';
            int num2 = Integer.parseInt(str.substring(i-2, i));

            if(num1 >= 1) dp[i] = dp[i-1];
            if(num2 >= 10 && num2 <= 26) dp[i] += dp[i-2];
            dp[i] %= 1000000;
        }

        System.out.print(dp[n]);
    }
}