import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        List<Integer>[] list = new ArrayList[N+1];
        for(int i = 1; i <= N; i++){
            list[i] = new ArrayList<>();
        }
        
        for(int i = 0; i < M; i++){
            List<Integer> temp = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            for(int j = 0; j < k; j++){
                temp.add(Integer.parseInt(st.nextToken()));
            }
            for(int j = 0; j < k - 1; j++){
                int x = temp.get(j);
                int y = temp.get(j + 1);
                list[x].add(y);
            }
        }
        
        List<Integer> result = new ArrayList<>();
        
        int[] degree = new int[N + 1];
        for(int i = 1; i <= N; i++){
            for(int neighbor : list[i]){
                degree[neighbor]++;
            }
        }
        
        Queue<Integer> que = new LinkedList<>();
        for(int i = 1; i <= N; i++){
            if(degree[i] == 0) que.offer(i);
        }
        
        while(!que.isEmpty()){
            int current = que.poll();
            result.add(current);
            
            for(int neighbor : list[current]){
                degree[neighbor]--;
                if(degree[neighbor] == 0){
                    que.offer(neighbor);
                }
            }
        }
        
        if(result.size() != N){
            System.out.print(0);
        }else{
            for(int node : result){
                System.out.println(node);
            }
        }
    }
}