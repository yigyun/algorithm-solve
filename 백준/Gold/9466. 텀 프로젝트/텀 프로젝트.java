import java.util.*;
import java.io.*;

class Main{

    static int T;
    static int n;
    static int[] student;
    static boolean[] visited;
    static boolean[] finished;
    static int count;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        T = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();


        for(int turn = 0; turn < T; turn++){
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            count = 0;
            student = new int[n+1];
            visited = new boolean[n+1];
            finished = new boolean[n + 1];

            st = new StringTokenizer(br.readLine());
            for(int i = 1; i <= n; i++){
                student[i] = Integer.parseInt(st.nextToken());
            }

            for(int i = 1; i <= n; i++){
                if(!visited[i]){
                    bfs(i);
                }
            }

            sb.append(n-count).append("\n");
        }
        System.out.print(sb.toString());
    }

    static void  bfs(int start){
        Queue<Integer> que = new LinkedList<>();
        List<Integer> path = new ArrayList<>();
        visited[start] = true;
        que.offer(start);

        boolean check = false;

        while(!que.isEmpty()){
            int current = que.poll();
            path.add(current);
            int next = student[current];

            if(!visited[next]){
                visited[next] = true;
                que.offer(next);
            } else if(!finished[next]){
                for (int i = path.indexOf(next); i < path.size(); i++) {
                    count++;
                }
                break;
            }
        }

        for (int node : path) {
            finished[node] = true;
        }
    }
}