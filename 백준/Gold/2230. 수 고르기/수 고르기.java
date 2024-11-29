import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] nums = new int[N];

        for(int i = 0; i < N; i ++){
            nums[i] = sc.nextInt();
        }
        Arrays.sort(nums);

        int start = 0;
        int end = 1;
        int gap = Integer.MAX_VALUE;

        while(end < N){
            int num = nums[end] - nums[start];
            if(num >= M){
                gap = Math.min(gap, num);
                start++;
            }else{
                end++;
            }
            
            if(start == end){
                end++;
            }
        }

        System.out.print(gap);
    }
}