import java.util.*;
import java.io.*;

class Main{

    static int n, k;
    static int max = 100001;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        int min = Integer.MAX_VALUE;

        Queue<int[]> q = new LinkedList<>();
        boolean[] visited = new boolean[max];
        q.offer(new int[]{n, 0});

        while(!q.isEmpty()){
            int[] num = q.poll();
            int x = num[0], y = num[1];

            visited[x] = true;
            if(x == k) min = Math.min(min, y);

            if(x * 2 < max && !visited[x * 2]) q.offer(new int[]{x * 2, y});
            if((x + 1) < max && !visited[x + 1]) q.offer(new int[]{x + 1, y+1});
            if(x - 1 >= 0 && !visited[x - 1]) q.offer(new int[]{x - 1, y+1});
        }


        System.out.print(min);
    }
}