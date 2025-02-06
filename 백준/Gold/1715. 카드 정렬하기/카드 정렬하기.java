import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> que = new PriorityQueue<>();

        for(int i = 0; i < n; i++){
            que.offer(Integer.parseInt(br.readLine()));
        }

        long ans = 0;

        while(que.size() > 1){
            int n1 = que.poll();
            int n2 = que.poll();

            ans += n1 + n2;
            que.offer(n1 + n2);
        }

        System.out.print(ans);
    }
}