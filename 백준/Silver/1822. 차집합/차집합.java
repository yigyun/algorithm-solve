import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int[] numA = new int[a];
        int[] numB = new int[b];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < a; i++){
            numA[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < b; i++){
            numB[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(numA);
        Arrays.sort(numB);
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < a; i++){
            int num = numA[i];

            int start = 0;
            int end = b-1;
            boolean check = true;
            while(start <= end){
                int mid = (start + end) / 2;

                if(numB[mid] == num){
                    check = false;
                    break;
                }else if(numB[mid] < num){
                    start = mid + 1;
                }else end = mid - 1;
            }
            if(check) list.add(num);
        }

        StringBuilder sb = new StringBuilder();
        sb.append(list.size()).append("\n");

        for(int num : list){
            sb.append(num).append(" ");
        }

        System.out.print(sb.toString());
    }
}