import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] nums = new int[n+1];
        Arrays.fill(nums, Integer.MAX_VALUE);
        nums[n] = 1;
        for(int i = n; i >= 1; i--){
            if(nums[i] == 0) continue;

            if(i % 3 == 0) nums[i / 3] = Math.min(nums[i / 3], nums[i] + 1);
            if(i % 2 == 0) nums[i / 2] = Math.min(nums[i / 2], nums[i] + 1);
            nums[i-1] = Math.min(nums[i-1], nums[i] + 1);
        }

        System.out.print(nums[1] - 1);
    }
}