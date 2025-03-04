import java.util.*;
import java.io.*;

class Main{

    static int n,m;
    static int[] nums;
    static int[] visited;
    static Set<String> set;
    static StringBuilder sb;

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
        visited = new int[m];
        back(0);

        System.out.print(sb);
    }

    static void back(int count){
        if(count == m){
            StringBuilder temp = new StringBuilder();
            for(int i = 0; i < m; i++){
                temp.append(visited[i]).append(' ');
            }

            if(!set.contains(temp.toString())){
                set.add(temp.toString());
                sb.append(temp).append('\n');
            }

            return;
        }

        for(int i = 0; i < n; i++){
            visited[count] = nums[i];
            back(count+1);
        }
    }
}