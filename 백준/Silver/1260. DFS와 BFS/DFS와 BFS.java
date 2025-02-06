import java.util.*;
import java.io.*;

class Main{

    static int n;
    static int m;
    static int v;
    static List<Integer>[] graph;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken());

        graph = new ArrayList[n+1];
        for(int i = 1; i <= n; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph[u].add(v);
            graph[v].add(u);
        }

        dfs();
        bfs();
    }

    static void dfs(){
        boolean[] visited = new boolean[n+1];
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        stack.push(v);

        while(!stack.isEmpty()){
            int cur = stack.pop();
            if(visited[cur]) continue;
            visited[cur] = true;
            sb.append(cur).append(" ");

            Collections.sort(graph[cur], Collections.reverseOrder());
            for(int next : graph[cur]){
                if(!visited[next]){
                    stack.push(next);
                }
            }
        }

        sb.append('\n');
        System.out.print(sb);
    }

    static void bfs(){
        boolean[] visited = new boolean[n+1];
        Queue<Integer> que = new LinkedList<>();
        StringBuilder sb = new StringBuilder();

        visited[v] = true;
        que.offer(v);

        while(!que.isEmpty()){
            int cur = que.poll();
            sb.append(cur).append(" ");

            Collections.sort(graph[cur]);
            for(int next : graph[cur]){
                if(!visited[next]){
                    visited[next] = true;
                    que.offer(next);
                }
            }
        }

        System.out.print(sb);
    }
}