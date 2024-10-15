import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        int[][] dp = new int[num][num];

        for(int i = 1; i <= num; i++){
            for(int j = 0; j < i; j++){
                dp[i-1][j] = sc.nextInt();
            }
        }

        for(int i = 1; i < num; i++){
            for(int j = 0; j < num; j++){
                if( j == 0){
                    dp[i][j] += dp[i-1][j];
                }else {
                    dp[i][j] += Math.max(dp[i - 1][j], dp[i - 1][j - 1]);
                }
            }
        }

        int max = -1;
        for(int i = 0; i < num; i++){
            max = Math.max(dp[num-1][i], max);
        }

        System.out.print(max);

    }
}