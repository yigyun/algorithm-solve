import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] nums = new int[n];
        List<Integer> two = new ArrayList<>();

        for(int i = 0; i < n; i++){
            nums[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(nums);

        for(int i = 0; i < n; i++){
            for(int j = i; j < n; j++){
                two.add(nums[i] + nums[j]);
            }
        }

        Collections.sort(two);

        for(int i = n-1; i > 0; i--){
            for(int j = 0; j < i; j++){
                if(Collections.binarySearch(two, nums[i] - nums[j]) >= 0){
                    System.out.print(nums[i]);
                    return;
                }
            }
        }
    }
}