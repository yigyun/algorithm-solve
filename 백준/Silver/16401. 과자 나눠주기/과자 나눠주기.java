import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int maxLength = 0;
        st = new StringTokenizer(br.readLine());
        int[] snacks = new int[N];
        for(int i = 0; i < N; i++){
            snacks[i] = Integer.parseInt(st.nextToken());
            maxLength = Math.max(maxLength, snacks[i]);
        }
        // 길이
        long start = 1;
        long end = maxLength;
        long result = 0;

        while(start <= end){
            long mid = (start + end) / 2;

            if(cal(M, mid, snacks)){
                result = mid;
                start = mid + 1;
            }else{
                end = mid -1;
            }
        }

        System.out.print(result);
    }
    
    static boolean cal(int M, long length, int[] snacks){
        if(length == 0) return false;
        long count = 0;
        for(int snack : snacks){
            count += snack / length;
        }
        return count >= M;
    }
}