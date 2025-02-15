import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // k = 1, s = 2
        int n = Integer.parseInt(br.readLine());
        int[] nums = new int[1001];
        
        nums[1] = 2;
        nums[2] = 1;
        nums[3] = 2;
        nums[4] = 2;
        
        for(int i = 5; i <= n; i++){
            if(nums[i - 3] == 1 || nums[i - 1] == 1 || nums[i - 4] == 1){
                nums[i] = 2;
            }else{
                nums[i] = 1;
            }
        }
        
        System.out.print(nums[n] == 1 ? "CY" : "SK");
    }
}