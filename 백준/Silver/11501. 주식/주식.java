import java.util.*;
import java.io.*;

class Main{

    // 뒤에서부터가야함.
    // 나보다 큰수가나오면 내 가격에 stock 털고 개선함.
    //
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        for(int tk = 0; tk < t; tk++){
            int n = Integer.parseInt(br.readLine());
            int[] nums = new int[n];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i = 0; i < n; i++){
                nums[i] = Integer.parseInt(st.nextToken());
            }
            
            long price = 0;
            long result = 0;
            
            for(int i = n-1; i >= 0; i--){
                if(nums[i] > price){
                    price = nums[i];
                }else{
                    result += price - nums[i];
                }
            }

            sb.append(result).append('\n');
        }

        System.out.print(sb);
    }
}