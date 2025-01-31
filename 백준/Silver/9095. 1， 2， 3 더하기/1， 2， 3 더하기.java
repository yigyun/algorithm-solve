import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        int[] nums = new int[12];
        nums[1] = 1;
        nums[2] = 2;
        nums[3] = 4;
        for(int i = 4; i < 12; i++){
            nums[i] = nums[i-1] + nums[i-2] + nums[i-3];
        }

        for(int i = 0; i < n; i++){
            int num = Integer.parseInt(br.readLine());
            sb.append(nums[num]).append('\n');
        }

        System.out.print(sb);
    }
}