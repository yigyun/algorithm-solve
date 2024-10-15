import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] num = new int[N];
        int[] dp = new int[N];

        for(int i = 0; i < N; i++){
            num[i] = sc.nextInt();
        }

        dp[0] = num[0];
        if (N > 1) {
            dp[1] = num[0] + num[1];
        }
        if(N > 2){
            dp[2] = Math.max(num[1] + num[2], num[0] + num[2]);
        }

        for(int i = 3; i < N; i++){
            dp[i] = Math.max(dp[i - 2] + num[i], dp[i - 3] + num[i - 1] + num[i]);
        }

        System.out.print(dp[N-1]);
    }
}