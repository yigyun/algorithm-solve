import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[] weight = new int[n];
        for(int i = 0; i < n; i++){
            weight[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(weight);
        int result = 0;
        for(int i = 1; i <= n; i++){
            result = Math.max(result, weight[n-i] * i);
        }
        
        System.out.print(result);
    }
}