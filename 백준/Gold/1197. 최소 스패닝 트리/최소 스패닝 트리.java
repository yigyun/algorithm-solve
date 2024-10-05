import java.util.*;
import java.io.*;

class Main{

    static int V;
    static int E;

    static long result;

    static class Edge{
        int x;
        int y;
        int w;
        Edge(int x, int y, int w){
            this.x = x; this.y = y; this.w = w;
        }
    }

    static int[] parent;
    static int find(int node) {
        if (parent[node] == node) return node;
        return parent[node] = find(parent[node]);
    }
    static void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        if (rootA != rootB) {
            parent[rootB] = rootA;
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        PriorityQueue<Edge> que = new PriorityQueue<>((o1, o2) -> {
            return o1.w - o2.w;
        });

        parent = new int[V + 1];
        for (int i = 1; i <= V; i++) {
            parent[i] = i;
        }

        List<Edge> list = new ArrayList<>();

        for(int i = 0; i < E; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            que.offer(new Edge(x, y, w));
        }
        result = 0;
        while(!que.isEmpty()){
            Edge current = que.poll();
            int rootX = find(current.x);
            int rootY = find(current.y);

            if (rootX != rootY) {
                union(current.x, current.y);
                list.add(current);
                result += current.w;
            }
        }

        System.out.print(result);

    }
}