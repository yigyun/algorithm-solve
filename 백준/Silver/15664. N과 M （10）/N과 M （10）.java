import java.util.*;
import java.io.*;

class Main{

    static int n, m;
    static int[] nums;
    static boolean[] visited;
    static StringBuilder sb;
    static Set<String> set;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        set = new HashSet<>();
        sb = new StringBuilder();

        nums = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(nums);
        visited = new boolean[n];

        back(0, 0);

        System.out.print(sb);
    }

    static void back(int idx, int count){
        if(count == m){
            StringBuilder temp = new StringBuilder();
            for(int i = 0; i < n; i++){
                if(visited[i])
                    temp.append(nums[i]).append(' ');
            }

            if(!set.contains(temp.toString())){
                set.add(temp.toString());
                sb.append(temp).append('\n');
            }

            return;
        }

        for(int i = idx; i < n; i++){
            if(!visited[i]){
                visited[i] = true;
                back(i + 1, count + 1);
                visited[i] = false;
            }
        }
    }
}