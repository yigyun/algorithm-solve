import java.util.*;
import java.io.*;

class Main{

    static int n, m;
    static int[] nums;
    static boolean[] visited;
    static int[] path;
    static StringBuilder sb;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        sb = new StringBuilder();
        nums = new int[n];
        visited = new boolean[n];
        path = new int[m];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(nums);
        Arrays.fill(path, -1);

        back(0);

        System.out.print(sb);
    }

    static void back(int count){
        if(count == m){
            for(int i = 0; i < m; i++){
                sb.append(nums[path[i]]).append(" ");
            }
            sb.append('\n');
            return;
        }

        for(int i = 0; i < n; i++){
            if(!visited[i]){
                visited[i] = true;
                path[count] = i;
                back(count + 1);
                path[count] = -1;
                visited[i] = false;
            }
        }
    }
}