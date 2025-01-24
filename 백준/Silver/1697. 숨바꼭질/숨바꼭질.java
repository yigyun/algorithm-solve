import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] nums = new int[200000];
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        Queue<Integer> que = new LinkedList<>();
        que.offer(n);

        while(!que.isEmpty()){
            int cur = que.poll();

            if(cur == x){
                System.out.print(nums[cur]);
                return;
            }

            if(cur + 1 < 200000 && nums[cur + 1] == 0){
                nums[cur+1] = nums[cur] + 1;
                que.offer(cur + 1);
            }
            if(cur - 1 >= 0 && nums[cur - 1] == 0){
                nums[cur - 1] = nums[cur] + 1;
                que.offer(cur - 1);
            }
            if(cur * 2 < 200000 && nums[cur * 2] == 0){
                nums[cur * 2] = nums[cur] + 1;
                que.offer(cur * 2);
            }
        }
    }
}