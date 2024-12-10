import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int count = 0;

        StringBuilder sb = new StringBuilder();
        int[] dp = new int[x + 1];
        dp[x] = 1;
        for(int i = x; i > 0; i--){
            if(dp[i] == 0) continue;

            if(i % 3  == 0) {
                if(dp[i/3] == 0) dp[i/3] = dp[i] + 1;
                else dp[i / 3] = Math.min(dp[i/3], dp[i] + 1);
            }
            if(i % 2 == 0) {
                if(dp[i/2] == 0) dp[i/2] = dp[i] + 1;
                else dp[i/2] = Math.min(dp[i/2], dp[i] + 1);
            }
            if(dp[i-1] == 0){
                dp[i-1] = dp[i] + 1;
            } else dp[i-1] = Math.min(dp[i-1], dp[i] + 1);
        }

        int c = dp[1] - 1;
        int i = 1;
        List<Integer> list = new ArrayList<>();
        list.add(1);

        while(i != x){
            if(i * 3 <= x && dp[i * 3] == c ){
                i *= 3;
            } else if (i* 2 <= x && dp[i*2] == c) {
                i *= 2;
            }else{
                i++;
            }
            list.add(i);
            c--;
        }
        sb.append(dp[1] - 1).append("\n");

        Collections.reverse(list);
        for(int num : list){
            sb.append(num).append(" ");
        }


        System.out.print(sb.toString());
    }
}