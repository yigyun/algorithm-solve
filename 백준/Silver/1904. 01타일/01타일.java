import java.util.*;
import java.io.*;

class Main{

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        // 모양이 -2에서 00 붙이고, -1꺼에서 1 붙이면 됨.
        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[0] = 1;
        
        for(int i = 2; i <= n; i++){
            dp[i] = (dp[i-1] + dp[i-2]) % 15746;
        }
        
        System.out.print(dp[n]);
    }
}