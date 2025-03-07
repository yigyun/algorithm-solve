import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] seq = new int[n];
        int[] nums = new int[100001];
        int result = 0;

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            seq[i] = Integer.parseInt(st.nextToken());
        }

        int s = 0;
        for(int e = 0; e < n; e++){
            int num = seq[e];
            nums[num]++;
            while(nums[num] > k){
                nums[seq[s]]--;
                s++;
            }
            
            result = Math.max(result,e-s+1);
        }

        System.out.print(result);
    }
}