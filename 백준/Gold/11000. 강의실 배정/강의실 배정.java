import java.util.*;
import java.io.*;

class Main{

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> q = new PriorityQueue<>();
        List<int[]> list = new ArrayList<>();
        int size = Integer.MIN_VALUE;

        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            list.add(new int[]{s, t});
        }

        Collections.sort(list, (o1, o2) -> {
            if(o1[0] == o2[0]){
                return o1[1] - o2[1];
            }
            return o1[0] - o2[0];
        });

        for(int[] node : list){
            if(!q.isEmpty()){
                if(node[0] < q.peek()){
                    q.offer(node[1]);
                    size = Math.max(q.size(), size);
                }else{
                    q.poll();
                    q.offer(node[1]);
                }
            }else{
                q.offer(node[1]);
                size = Math.max(q.size(), size);
            }
        }

        System.out.print(size);
    }
}