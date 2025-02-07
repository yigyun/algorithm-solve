import java.util.*;
import java.io.*;

class Main{

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] none = new int[n+1][n+1];
        for(int i = 1; i <= n; i++){
            none[0][i] = Integer.parseInt(br.readLine());
        }

        for(int i = 1; i <= n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= n; j++){
                none[i][j] = Integer.parseInt(st.nextToken());
            }
            none[i][0] = none[0][i];
        }

        // 1 시작
        boolean[] visited= new boolean[n+1];
        int count = 1;
        visited[1] = true;
        int result = 0;
        PriorityQueue<int[]> q = new PriorityQueue<>((o1, o2) -> o1[0] - o2[0]);
        for(int i = 0; i <= n; i++){
            int num = none[1][i];
            if(num == 0) continue;
            q.offer(new int[]{num, i, 1});
        }

        while(!q.isEmpty() && count <= n){
            int[] cur = q.poll();
            int u = cur[2];
            int v = cur[1];
            int w = cur[0];

            if(visited[v]) continue;

            result += w;
            visited[v] = true;
            count++;

            for(int i = 0; i <= n; i++){
                int num = none[v][i];
                if(num == 0) continue;
                q.offer(new int[]{num, i, v});
            }
        }

        System.out.print(result);
    }
}