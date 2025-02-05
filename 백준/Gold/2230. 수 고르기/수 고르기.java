import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] nums = new int[n];
        for(int i = 0; i < n; i++){
            nums[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(nums);

        int result = Integer.MAX_VALUE;

        int sta = 0;
        int en = 0;

        while(sta < n-1 && en < n && sta <= en){
            int num = nums[en] - nums[sta];
            if(num >= m){
                result = Math.min(result, num);
                sta++;
            }else{
                en++;
            }
        }

        System.out.print(result);
    }
}