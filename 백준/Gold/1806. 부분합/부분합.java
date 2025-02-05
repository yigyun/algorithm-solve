import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] nums = new int[n];
        for(int i = 0; i < n; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }

        int sta = 0;
        int end = 0;
        int sum = nums[0];
        int min = Integer.MAX_VALUE;

        while(sta <= end && end < n){
            if(sum >= s){
                min = Math.min(min, end - sta);
                sum -= nums[sta];
                sta++;
            }else{
                end++;
                if(end < n) sum += nums[end];
            }
        }

        System.out.print(min == Integer.MAX_VALUE ? 0 : min + 1);
    }
}