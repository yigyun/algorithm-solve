import java.util.*;
import java.io.*;

class Main{

    static int n;
    static int m;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int[] indegree = new int[n+1];
        List<Integer>[] out = new ArrayList[n+1];
        StringBuilder sb = new StringBuilder();

        for(int i = 1; i <= n; i++){
            out[i] = new ArrayList<>();
        }

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            indegree[b]++;
            out[a].add(b);
        }

        Queue<Integer> que = new LinkedList<>();

        for(int i = 1; i <= n; i++){
            if(indegree[i] == 0){
                que.offer(i);
            }
        }

        while(!que.isEmpty()){
            int cur = que.poll();

            sb.append(cur).append(" ");
            for(int next : out[cur]){
                indegree[next]--;
                if(indegree[next] == 0){
                    que.offer(next);
                }
            }
        }

        System.out.print(sb);
    }
}