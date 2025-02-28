import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int answer = 0;

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] nums = new int[n + 1];

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++){
            nums[i] = Integer.parseInt(st.nextToken()) + nums[i-1];
        }


        int s = 0;
        int e = s + 1;

        while(s <= e && e <= n){
            if(nums[e] - nums[s] == m){
                answer++;
                s++;
            }else if(nums[e] - nums[s] < m){
                e++;
            }else{
                s++;
            }
        }

        System.out.print(answer);
    }
}