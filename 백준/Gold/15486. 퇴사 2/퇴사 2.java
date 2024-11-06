import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        int[][] nums = new int[N][2];
        long[] dp = new long[N+1];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            nums[i][0] = t;
            nums[i][1] = p;
        }

        long max = 0;
        for(int i = 0; i < N; i++){
            if(i+ nums[i][0] <= N){
                dp[i+nums[i][0]] = Math.max(dp[i+nums[i][0]], dp[i] + nums[i][1]);
            }
            dp[i+1] = Math.max(dp[i+1], dp[i]);
            max = Math.max(dp[i + 1], max);
        }

        System.out.println(max);
    }
}