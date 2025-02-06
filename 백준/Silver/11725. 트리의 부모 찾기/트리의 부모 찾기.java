import java.util.*;
import java.io.*;

class Main{

    static StringBuilder sb;
    static int n;
    static int[] result;

    static class Node{
        Node left;
        Node right;
        int val;
        public Node(int val){
            this.val = val;
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        sb = new StringBuilder();
        result = new int[n+1];

        result[1] = 1;
        List<Integer>[] list = new ArrayList[n+1];
        for(int i = 1; i <= n; i++){
            list[i] = new ArrayList<>();
        }

        for(int i = 0; i < n-1; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int u = Integer.parseInt(st.nextToken());

            list[v].add(u);
            list[u].add(v);
        }

        Queue<Integer> q = new LinkedList<>();
        q.offer(1);

        while(!q.isEmpty()){
            int cur = q.poll();

            for(int num : list[cur]){
                if(result[num] != 0) continue;
                result[num] = cur;
                q.offer(num);
            }
        }

        for(int i = 2; i <= n; i++){
            sb.append(result[i]).append("\n");
        }
        System.out.print(sb);
    }

}