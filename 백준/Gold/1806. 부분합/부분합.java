import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int S = sc.nextInt();
        
        int[] nums = new int[N];
        for(int i = 0; i < N; i++){
            nums[i] = sc.nextInt();
        }
                
        int start = 0;
        int end = 0;
        int length = N + 1;
        int sum = 0;
        
        while(end < N){
            sum += nums[end];
            end++;
                while(sum >= S){
                    length = Math.min(end - start, length);
                    sum -= nums[start];
                    start++;
                }
         
        }
        if(length == N + 1) length = 0;
        System.out.print(length);
    }
}