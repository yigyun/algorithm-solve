import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] nums = new int[N];
        for(int i = 0; i < N; i++){
            nums[i] = sc.nextInt();
        }

        int[] dp = new int[N];
        Arrays.fill(dp, 1);

        for(int i = 0; i < N; i++){
            for(int j = 0; j < i; j++){
                if(nums[i] > nums[j]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int index = 0;
        for(int i = 0; i < N; i++){
            index = Math.max(index, dp[i]);
        }

        StringBuilder sb = new StringBuilder();
        sb.append(index).append('\n');
        List<Integer> list= new ArrayList<>();
        for(int i = N -1; i >= 0; i--){
            if(dp[i] == index){
                index--;
                list.add(nums[i]);
            }
        }

        Collections.reverse(list);

        for(int num : list){
            sb.append(num).append(' ');
        }
        System.out.print(sb.toString());
    }
}