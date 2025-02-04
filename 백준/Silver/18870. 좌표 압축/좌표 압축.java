import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];  // 입력받을 배열
        HashMap<Integer, Integer> hm = new HashMap<Integer,Integer>();
        for(int i = 0; i < N ; i++)
        {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int[] sort = Arrays.copyOf(arr, arr.length); // 정렬할 배열
        Arrays.sort(sort);
        int rankNum = 0;
        for(int i : sort) {
            if (!hm.containsKey(i)){
                hm.put(i, rankNum++);
            }
        }
        for(int i : arr)
        {
            int num = hm.get(i);
            sb.append(num).append(' ');
        }
        System.out.print(sb);
    }
}