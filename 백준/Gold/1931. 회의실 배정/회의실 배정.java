import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        PriorityQueue<int[]> que = new PriorityQueue<>((o1, o2) -> {
            if(o2[1] == o1[1]){
                return o1[0] - o2[0];
            }
            return o1[1] - o2[1];
        });

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            que.offer(new int[]{x, y});
        }
        int t = 0, result = 0;

        while(!que.isEmpty()){
            int[] cur = que.poll();
            if(cur[0] < t) continue;
            result++;
            t = cur[1];

        }

        System.out.print(result);
    }
}