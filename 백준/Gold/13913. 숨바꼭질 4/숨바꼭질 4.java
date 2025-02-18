import java.util.*;
import java.io.*;

class Main{

    static int max = 100000;
    static StringBuilder sb;
    static int[] pos;
    static int n, k;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        pos = new int[max + 1];
        Arrays.fill(pos, max + 1);
        pos[n] = 0;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{n, 0});

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int x = cur[0];
            int c = cur[1];

            if(x == k) break;

            int num1 = x + 1;
            int num2 = x - 1;
            int num3 = x * 2;

            if(num3 <= max && pos[num3] > c + 1){
                pos[num3] = c + 1;
                q.offer(new int[]{num3, c + 1});
            }
            if(num1 <= max && pos[num1] > c + 1){
                pos[num1] = c + 1;
                q.offer(new int[]{num1, c + 1});
            }

            if(num2 >= 0 && pos[num2] > c + 1){
                pos[num2] = c + 1;
                q.offer(new int[]{num2, c + 1});
            }
        }

        sb = new StringBuilder();
        path();
        st = new StringTokenizer(sb.toString());
        List<String> list = new ArrayList<>();
        while(st.hasMoreTokens()){
            list.add(st.nextToken());
        }

        sb = new StringBuilder();
        sb.append(pos[k]).append('\n');
        for(int i = list.size() - 1; i >= 0; i--){
            sb.append(list.get(i)).append(" ");
        }

        System.out.print(sb);
    }

    static void path(){
        Queue<Integer> que = new LinkedList<>();
        que.offer(k);

        while(!que.isEmpty()){
            int cur = que.poll();
            sb.append(cur).append(" ");

            if(cur == n) break;

            int num = pos[cur];
            if((cur % 2) == 0 && pos[cur/2] == num - 1) que.offer(cur / 2);
            else if(cur + 1 <= max && pos[cur + 1] == num - 1) que.offer(cur + 1);
            else if(cur - 1 >= 0 && pos[cur - 1] == num - 1) que.offer(cur - 1);
        }
    }
}