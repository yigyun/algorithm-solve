import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[] sushi = new int[n];
        int[] type = new int[d+1];

        for(int i = 0; i < n; i++){
            sushi[i] = Integer.parseInt(br.readLine());
        }

        int count = 1;
        type[c]++;

        for(int i = 0; i < k; i++){
            if(type[sushi[i]] == 0){
                count++;
            }
            type[sushi[i]]++;
        }
        
        int maxCount = count;

        for(int i = 1; i < n; i++){
            int end = (i + k - 1) % n;
            
            if(type[sushi[end]] == 0){
                count++;
            }
            type[sushi[end]]++;
            
            type[sushi[i-1]]--;
            if(type[sushi[i-1]] == 0){
                count--;
            }

            maxCount = Math.max(maxCount, count);
        }

        System.out.print(maxCount);
    }
}