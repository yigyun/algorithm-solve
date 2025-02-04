import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        int[] ori = new int[n];
        int[] nums = new int[n];

        for(int i = 0; i < n; i++){
            int num = Integer.parseInt(st.nextToken());
            ori[i] = num;
            nums[i] = num;
        }

        Arrays.sort(nums);

        List<Integer> list = new ArrayList<>();

        for(int i = 0; i < n; i++){
            if(i == 0 || nums[i-1] != nums[i]) list.add(nums[i]);
        }

        for(int target : ori){
            int sta = 0;
            int end = list.size();
            while(sta < end){
                int mid = (sta + end) / 2;
                if(list.get(mid) < target) sta = mid + 1;
                else end = mid;
            }

            sb.append(sta).append(' ');
        }
        
        System.out.print(sb.toString());
    }
}