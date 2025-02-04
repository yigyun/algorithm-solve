import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        long[] nums = new long[n];
        long max = 0;

        for(int i = 0; i < n; i++){
            int num = Integer.parseInt(br.readLine());
            max = Math.max(max, num);
            nums[i] = num;
        }

        long sta = 1;
        long end = Integer.MAX_VALUE;

        while(sta < end){
            long mid = (sta + end + 1) / 2;

            long count = 0;
            for(long lan : nums){
                count += (lan / mid);
            }

            if(count < k){
                end = mid - 1;
            }else{
                sta = mid;
            }
        }

        System.out.print(sta);
    }
}