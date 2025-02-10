import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] nums = new int[n];

        for(int i = 0; i < n; i++){
            nums[i] = Integer.parseInt(br.readLine());
        }

        if (n == 1) {
            System.out.print(nums[0]);
            return;
        } else if (n == 2) {
            System.out.print(nums[0] + nums[1]);
            return;
        }


        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = nums[0] + nums[1];
        dp[2] = Math.max(nums[0] + nums[2], nums[1] + nums[2]);
        dp[2] = Math.max(dp[2], dp[1]);

        for(int i = 3; i < n; i++){
            dp[i] = Math.max(dp[i-1], Math.max(nums[i] + dp[i-2], nums[i] + dp[i-3] + nums[i-1]));
        }

        System.out.print(dp[n-1]);
    }
}