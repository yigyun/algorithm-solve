import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] cards = new int[N];
        for(int i = 0; i < N; i++){
            cards[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(cards);
        st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++){
            int num = Integer.parseInt(st.nextToken());
            int start = 0;
            int end = N-1;
            while(start <= end){
                int mid = (start + end) / 2;

                if(cards[mid] == num){
                    start = mid + 1;
                }else if(cards[mid] < num){
                    start = mid + 1;
                }else {
                    end = mid - 1;
                }
            }
            int upper = start;

            start = 0;
            end = N-1;
            while(start <= end){
                int mid = (start + end) / 2;

                if(cards[mid] >= num){
                    end = mid - 1;
                }else {
                    start = mid + 1;
                }
            }
            int lower = start;

            sb.append(upper - lower).append(" ");
        }

        System.out.print(sb.toString());
    }
}