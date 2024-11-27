import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(System.in);
        int K = sc.nextInt();
        int N = sc.nextInt();

        int[] nums = new int[K];
        for(int i = 0; i < K; i++){
            nums[i] = sc.nextInt();
        }

        Arrays.sort(nums);

        long start = 1;
        long end = nums[K-1];
        long result = 0;

        while(start <= end) {
            long mid = (start + end) / 2;

            long temp = 0;
            for (int i = 0; i < K; i++) {
                temp += nums[i] / mid;
            }
            if (temp >= N) {
                result = mid;
                start = mid + 1;
            }else {
                end = mid - 1;
            }
        }

        System.out.println(result);
    }
}