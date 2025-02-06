import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        PriorityQueue<Integer> que = new PriorityQueue<>((o1, o2) -> {
            int abs1 = Math.abs(o1);
            int abs2 = Math.abs(o2);
            if(abs1 == abs2) return o1 - o2;

            return abs1 - abs2;
        });

        for(int i = 0; i < n; i++){
            int num = Integer.parseInt(br.readLine());
            if(num == 0){
                if(que.isEmpty()) sb.append(0).append('\n');
                else{
                    sb.append(que.poll()).append('\n');
                }
            }else{
                que.add(num);
            }
        }

        System.out.print(sb);
    }
}