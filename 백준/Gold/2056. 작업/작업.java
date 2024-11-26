import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int[] times = new int[N+1];
        List<Integer>[] list = new ArrayList[N+1];
        for(int i = 1; i <= N; i++){
            list[i] = new ArrayList<>();
        }
        int[] degree = new int[N+1];
        for(int i = 1; i <= N; i++){
            st = new StringTokenizer(br.readLine());
            times[i] = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            for(int j = 0; j < c; j++){
                list[i].add(Integer.parseInt(st.nextToken()));
            }
        }

        for(int i = 1; i <= N; i++){
            for(int num : list[i]){
                degree[num]++;
            }
        }

        PriorityQueue<int[]> que = new PriorityQueue<>((o1, o2) -> {
            return o1[1] - o2[1];
        });
        int t = 0;
        for(int i = 1; i <= N; i++){
            if(degree[i] == 0){
                que.offer(new int[]{i, times[i]});
            }
        }

        while(!que.isEmpty()){
            int[] cur = que.poll();
            t = Math.max(t, cur[1]);
            for(int num : list[cur[0]]){
                degree[num]--;
                if(degree[num] == 0){
                    que.offer(new int[]{num, cur[1] + times[num]});
                }
            }
        }
        System.out.print(t);
    }
}