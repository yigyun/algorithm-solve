import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] nums = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }

        int min = Math.abs(nums[0] + nums[n-1]);

        int x = 0;
        int y = n-1;
        int s = 0;
        int e = n-1;

        while(s < e){
            int num = Math.abs(nums[s] + nums[e]);
            if(num < min){
                min = num;
                x = s;
                y = e;
            }

            if(nums[s] + nums[e] < 0){
                s++;
            }else{
                e--;
            }
        }

        System.out.print(nums[x] + nums[y]);
    }
}