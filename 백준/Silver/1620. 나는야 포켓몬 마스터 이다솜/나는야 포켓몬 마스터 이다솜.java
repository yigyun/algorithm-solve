import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Map<String, Integer> nameToNum = new HashMap<>();
        Map<Integer, String> numToName = new HashMap<>();

        for(int i = 1; i <= n; i++){
            String name = br.readLine();
            nameToNum.put(name, i);
            numToName.put(i, name);
        }

        StringBuilder sb = new StringBuilder();

        for(int i = 1; i <= m; i++){
            String find = br.readLine();
            if(nameToNum.containsKey(find)){
                sb.append(nameToNum.get(find)).append('\n');
            }else{
                sb.append(numToName.get(Integer.parseInt(find))).append('\n');
            }
        }

        System.out.print(sb);
    }
}