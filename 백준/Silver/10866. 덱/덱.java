import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        Deque<Integer> que = new ArrayDeque<>();

        for(int t = 0; t < n; t++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String op = st.nextToken();
            if(op.equals("push_back")){
                que.addLast(Integer.parseInt(st.nextToken()));
            }else if(op.equals("push_front")){
                que.addFirst(Integer.parseInt(st.nextToken()));
            }else if(op.equals("pop_front")){
                if(que.isEmpty()) sb.append(-1).append('\n');
                else sb.append(que.poll()).append('\n');
            }else if(op.equals("pop_back")){
                if(que.isEmpty()) sb.append(-1).append('\n');
                else sb.append(que.pollLast()).append('\n');
            }else if(op.equals("size")){
                sb.append(que.size()).append('\n');
            }else if(op.equals("empty")){
                if(que.isEmpty()) sb.append(1).append('\n');
                else sb.append(0).append('\n');
            }else if(op.equals("front")){
                if(que.isEmpty()) sb.append(-1).append('\n');
                else sb.append(que.peek()).append('\n');
            }else {
                if(que.isEmpty()) sb.append(-1).append('\n');
                else sb.append(que.peekLast()).append('\n');
            }
        }

        System.out.print(sb);
    }
}