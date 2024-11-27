import java.util.*;
import java.io.*;


class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long result = 0;
        int count = 0;
        Map<Long, Integer> map = new HashMap<>();
        for(int i = 0; i < N; i++){
            long num = Long.parseLong(br.readLine());
            map.put(num, map.getOrDefault(num, 0) + 1);
            int tc = map.get(num);
            if(count < tc){
                result = num;
                count = tc;
            }
            else if(count == tc){
                if(result > num) result = num;
            }
        }
        
        System.out.print(result);
    }
}