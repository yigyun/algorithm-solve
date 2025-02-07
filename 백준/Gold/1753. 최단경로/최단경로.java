import java.util.*;
import java.io.*;

class Main{

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(br.readLine());

        int[] ver = new int[V+1];
        List<int[]>[] edges = new ArrayList[V+1];
        for(int i = 1; i <= V; i++){
            edges[i] = new ArrayList<>();
        }

        for(int i = 0; i < e; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            edges[u].add(new int[]{v, w});
        }

        Arrays.fill(ver, Integer.MAX_VALUE);

        ver[k] = 0;
        PriorityQueue<int[]> que = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        que.offer(new int[]{k, 0});

        while(!que.isEmpty()){
            int[] cur = que.poll();
            int v = cur[0];
            int w = cur[1];

            if(ver[v] != w) continue;

            for(int[] node : edges[v]){
                int nx = node[0];
                int nw = node[1];
                if(ver[nx] > w + nw){
                    ver[nx] = w + nw;
                    que.offer(new int[]{nx, w + nw});
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        for(int i = 1; i <= V; i++){
            if(ver[i] == Integer.MAX_VALUE) sb.append("INF").append('\n');
            else sb.append(ver[i]).append('\n');
        }

        System.out.print(sb);
    }
}