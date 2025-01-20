import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        
        int[] nums = new int[10];
        for(char ch : str.toCharArray()){
            nums[ch - '0']++;
        }
        
        int set = 0;
        
        for(int i = 0; i < 10; i++){
            if(i == 6 || i == 9){
                int num = nums[6] + nums[9];
                if(num % 2 == 1) num++;
                set = Math.max(set, num / 2);
            }else{
                set = Math.max(set, nums[i]);
            }
        }
        
        System.out.print(set);
    }
}