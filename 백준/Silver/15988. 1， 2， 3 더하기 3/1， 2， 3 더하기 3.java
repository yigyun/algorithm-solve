import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        int LENGTH = 1000001;
        int DIVIDE = 1000000009;
        int[] dp = new int[LENGTH];

        dp[1] = 1; // 1
        dp[2] = 2; // 11, 2
        dp[3] = 4; // 111, 12, 21, 3
        for(int i = 4; i < LENGTH; i++){
            dp[i] = ((dp[i-1] + dp[i-2]) % DIVIDE + dp[i-3]) % DIVIDE;
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < t; i++){
            int num = Integer.parseInt(br.readLine());
            if(i == t-1) sb.append(dp[num]);
            else sb.append(dp[num]).append('\n');
        }

        System.out.print(sb.toString());
    }
}