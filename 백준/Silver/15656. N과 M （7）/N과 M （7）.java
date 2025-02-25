import java.util.*;
import java.io.*;

class Main{

    static int n, m;
    static int[] nums;
    static int[] visited;
    static StringBuilder sb;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        nums = new int[n];
        visited = new int[m];
        sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(nums);

        back(0);

        System.out.print(sb);
    }

    static void back(int count){
        if(count == m){
            for(int i = 0; i < m; i++){
                sb.append(nums[visited[i]]).append(' ');
            }
            sb.append('\n');
            return;
        }

        for(int i = 0; i < n; i++){
            visited[count] = i;
            back(count + 1);
            visited[count] = -1;
        }
    }
}