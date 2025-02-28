import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        Map<Integer, Integer> problem = new HashMap<>();

        PriorityQueue<int[]> p1Q = new PriorityQueue<>((o1, o2) -> {
            if(o1[1] == o2[1]){
                return o2[0] - o1[0];
            }
            return o2[1] - o1[1];
        });
        PriorityQueue<int[]> m1Q = new PriorityQueue<>((o1, o2) -> {
            if(o1[1] == o2[1]){
                return o1[0] - o2[0];
            }
            return o1[1] - o2[1];
        });

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int level = Integer.parseInt(st.nextToken());
            p1Q.add(new int[]{num, level});
            m1Q.add(new int[]{num, level});
            problem.put(num, level);
        }

        int m = Integer.parseInt(br.readLine());
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            String op = st.nextToken();
            // add
            if(op.equals("add")){
                int num = Integer.parseInt(st.nextToken());
                int level = Integer.parseInt(st.nextToken());
                p1Q.add(new int[]{num, level});
                m1Q.add(new int[]{num, level});
                problem.put(num, level);
            }else if(op.equals("recommend")){
                // recommend
                int num = Integer.parseInt(st.nextToken());
                if(num == 1){
                    // p1Q
                    while(!p1Q.isEmpty() && (!problem.containsKey(p1Q.peek()[0]) || problem.get(p1Q.peek()[0]) != p1Q.peek()[1])){
                        p1Q.poll();
                    }

                    int[] pb = p1Q.peek();
                    sb.append(pb[0]).append('\n');
                }else{
                    // m1Q
                    while(!m1Q.isEmpty() && (!problem.containsKey(m1Q.peek()[0]) || problem.get(m1Q.peek()[0]) != m1Q.peek()[1])){
                        m1Q.poll();
                    }
                    int[] pb = m1Q.peek();
                    sb.append(pb[0]).append('\n');
                }
            }else{
                //solved
                int num = Integer.parseInt(st.nextToken());
                problem.remove(num);
            }
        }

        System.out.print(sb);
    }
}