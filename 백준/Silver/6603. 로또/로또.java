import java.util.*;
import java.io.*;

class Main{

    static StringBuilder sb;
    static int[] nums;
    static boolean[] visited;
    static int k;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();

        k = Integer.parseInt(st.nextToken());
        while(k != 0){
            nums = new int[k];
            visited = new boolean[k];
            for(int i = 0; i < k; i++){
                nums[i] = Integer.parseInt(st.nextToken());
            }

            back(0, 0);
            sb.append('\n');
            st = new StringTokenizer(br.readLine());
            k = Integer.parseInt(st.nextToken());
        }

        System.out.print(sb);
    }

    static void back(int idx, int count){
        if(count == 6){
            for(int i = 0; i < k; i++){
                if(visited[i]){
                    sb.append(nums[i]).append(' ');
                }
            }
            sb.append('\n');
            return;
        }

        for(int i = idx; i < k; i++){
            if(!visited[i]){
                visited[i] = true;
                back(i + 1, count + 1);
                visited[i] = false;
            }
        }
    }
}