import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] nums = new int[201];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            int num = Integer.parseInt(st.nextToken());
            if(num < 0) num = Math.abs(num) + 100;
            nums[num]++;
        }
        
        int v = Integer.parseInt(br.readLine());
        if(v < 0) v = Math.abs(v) + 100;
        
        System.out.print(nums[v]);
    }
}