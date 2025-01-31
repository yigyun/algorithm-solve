import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        int[] nums = new int[n+1];
        Arrays.fill(nums, Integer.MAX_VALUE);
        int[] dp = new int[n+1];

        nums[1] = 0;
        for(int i = 1; i <= n; i++){
            if(nums[i] == Integer.MAX_VALUE) continue;
            if(i * 3 <= n && nums[i*3] > nums[i] + 1){
                nums[i*3] = nums[i] + 1;
                dp[i*3] = i;
            }
            if(i * 2 <= n && nums[i*2] > nums[i] + 1){
                nums[i*2] = nums[i] + 1;
                dp[i*2] = i;
            }
            if(i + 1 <= n && nums[i+1] > nums[i] + 1){
                nums[i+1] = nums[i] + 1;
                dp[i+1] = i;
            }
        }

        sb.append(nums[n]).append('\n');
        int idx = n;
        sb.append(n).append(' ');
        while(idx != 1){
            sb.append(dp[idx]).append(' ');
            idx = dp[idx];
        }

        System.out.println(sb);
    }
}