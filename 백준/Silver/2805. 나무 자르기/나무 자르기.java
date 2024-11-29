import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] trees = new int[N];
        int max = 0;
        for(int i = 0; i < N; i++){
            trees[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, trees[i]);
        }

        int start = 0;
        int end = max;
        int result = 0;

        while(start <= end){
            int mid = (start + end) / 2;

            long count = 0;
            for(int i = 0; i < N; i++){
                count += trees[i] - mid > 0? trees[i] - mid : 0;
            }

            if(count >= M){
                result = mid;
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }

        System.out.print(result);
    }
}