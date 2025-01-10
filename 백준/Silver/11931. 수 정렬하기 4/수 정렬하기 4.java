import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Integer[] nums = new Integer[N];
        for(int i = 0; i < N; i++){
            nums[i] = sc.nextInt();
        }
        
        Arrays.sort(nums, Collections.reverseOrder());
        
        StringBuilder sb = new StringBuilder();
        for(int num : nums){
            sb.append(num).append('\n');
        }
        System.out.print(sb.toString().trim());
    }
}