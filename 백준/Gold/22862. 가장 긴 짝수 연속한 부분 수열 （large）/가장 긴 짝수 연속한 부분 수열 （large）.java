import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int max = 0;

        int[] nums = new int[n];

        int s = 0; // 시작
        int c = 0; // 홀수의 갯수
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }

        for(int e = 0; e < n; e++){
            if(nums[e] % 2 == 1){
                c++;
            }

            while(c > k){
                if(nums[s] % 2 == 1){
                    c--;
                }
                s++;
            }

            max = Math.max(max, e - s + 1 - c);
        }

        System.out.print(max);
    }
}