import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int W = sc.nextInt();
        int[] jadu = new int[T + 1];
        for(int i = 1; i <= T; i++){
            jadu[i] = sc.nextInt();
        }

        int[][][] dp = new int[T + 1][W + 1][2];
        
        // 1초에 1번 나무
        if(jadu[1] == 1){
            dp[1][0][0] = 1;
            dp[1][1][1] = 0;
        }else{
            dp[1][1][1] = 1;
            dp[1][0][0] = 0;
        }

        for(int t = 2; t <= T; t++){
            for(int w = 0; w <= W; w++){
                if (w == 0) {
                    dp[t][w][0] = dp[t - 1][w][0] + (jadu[t] == 1 ? 1 : 0);
                    dp[t][w][1] = dp[t - 1][w][1] + (jadu[t] == 2 ? 1 : 0);
                } else {
                    dp[t][w][0] = Math.max(dp[t - 1][w][0], dp[t - 1][w - 1][1]) + (jadu[t] == 1 ? 1 : 0);
                    dp[t][w][1] = Math.max(dp[t - 1][w][1], dp[t - 1][w - 1][0]) + (jadu[t] == 2 ? 1 : 0);
                
                }
            }
        }
        
        int max = 0;
        for(int w = 0; w <= W; w++){
            max = Math.max(max, Math.max(dp[T][w][0], dp[T][w][1]));
        }
        
        System.out.print(max);
    }
}