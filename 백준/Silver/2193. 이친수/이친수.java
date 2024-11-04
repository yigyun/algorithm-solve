import java.util.*;
import java.io.*;

class Main{

    static int N;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        long[] dp = new long[N+1];
        dp[1] = 1;

        if(N > 1){
            dp[2] = 1;
        }

        for(int i = 3; i<= N; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }

        System.out.print(dp[N]);
    }
}