// 절댓값이 가장 작아질수록 좋은거임

import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] nums = new int[n];
        for(int i = 0; i < n; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }

        int min = Math.abs(nums[0] + nums[n-1]);
        int x = 0;
        int y = n-1;
        int s = 0;
        int e = n-1;

        while(s < e){
            int sum = nums[s] + nums[e];

            if(Math.abs(sum) < min){
                x = s;
                y = e;
                min = Math.abs(sum);
            }

            if(sum < 0){
                s++;
            }else{
                e--;
            }
        }

        System.out.print(nums[x] + " " + nums[y]);
    }
}