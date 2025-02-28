import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.*;

class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int answer = 0;

        int sn = 0;
        boolean[] nums = new boolean[n+1];
        for(int i = 2; i <= n; i++){
            if(!nums[i]){
                int num = i + i;
                sn++;
                while(num <= n){
                    nums[num] = true;
                    num += i;
                }
            }
        }

        int[] dp = new int[sn + 1];
        int idx = 1;
        for(int i = 2; i <= n; i++){
            if(!nums[i]){
                dp[idx++] = i;
            }
        }

        for(int i = 1; i <= sn; i++){
            dp[i] += dp[i-1];
        }

        int s = 0;
        int e = s + 1;
        while(s <= e && e <= sn){
            if(dp[e] - dp[s] == n){
                s++;
                answer++;
            }else if(dp[e] - dp[s] > n){
                s++;
            }else{
                e++;
            }
        }

        System.out.print(answer);
    }
}