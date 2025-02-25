import java.util.*;
import java.io.*;

class Main{

    static int n, m;
    static int[] nums;
    static int[] visited;
    static StringBuilder sb;
    static Set<String> set;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        sb = new StringBuilder();
        set = new HashSet<>();

        nums = new int[n];
        visited = new int[m];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(nums);

        back(0, 0);

        System.out.print(sb);
    }

    static void back(int count, int num){
        if(count == m){
            StringBuilder temp = new StringBuilder();
            for(int i = 0; i < m; i++){
                temp.append(nums[visited[i]]).append(' ');
            }
            if(!set.contains(temp.toString())){
                set.add(temp.toString());
                sb.append(temp).append('\n');
            }
            return;
        }

        for(int i = 0; i < n; i++){
            if(num > nums[i]) continue;
            visited[count] = i;
            back(count+1, nums[i]);
            visited[count] = -1;
        }
    }
}