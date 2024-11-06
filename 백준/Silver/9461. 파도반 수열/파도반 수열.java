import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        long[] nums = new long[101];
        nums[1] = 1; nums[2] = 1; nums[3] = 1;

        for(int i = 4; i < 101; i++){
            nums[i] = nums[i-2] + nums[i-3];
        }
        for(int i = 0; i < t; i++){
            int n = sc.nextInt();
            System.out.println(nums[n]);
        }
    }
}