import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] nums = new int[n];
        Arrays.fill(nums, -1);

        Stack<int[]> stack = new Stack<>();
        for(int i = 0; i < n; i++){
            int nge = Integer.parseInt(st.nextToken());
            while(!stack.isEmpty() && stack.peek()[0] < nge){
                int[] cur = stack.pop();
                nums[cur[1]] = nge;
            }
            stack.push(new int[]{nge, i});
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++){
            sb.append(nums[i]).append(' ');
        }

        System.out.print(sb);
    }
}