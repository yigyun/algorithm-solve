import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] sts = new int[7][2]; // 0 여, 1 남
        int result = 0;
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        
        for(int t = 0; t < n; t++){
            st = new StringTokenizer(br.readLine());
            int sex = Integer.parseInt(st.nextToken());
            int grade = Integer.parseInt(st.nextToken());
            
            sts[grade][sex]++;
        }
        
        for(int i = 1; i <= 6; i++){
            for(int j = 0; j <= 1; j++){
                if(sts[i][j] % k != 0) result++;
                result += sts[i][j] / k;
            }
        }
        
        System.out.print(result);
    }
}