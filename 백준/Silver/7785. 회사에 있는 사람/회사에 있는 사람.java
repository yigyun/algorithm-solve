import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        Set<String> set = new HashSet<>();
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            String op = st.nextToken();

            if(set.contains(name) && op.equals("leave")){
                set.remove(name);
            }
            else{
                if(op.equals("enter"))
                    set.add(name);
            }
        }

        StringBuilder sb = new StringBuilder();
        String[] names = set.toArray(new String[set.size()]);
        Arrays.sort(names, (a, b) -> b.compareTo(a));

        for(String name : names){
            sb.append(name).append('\n');
        }

        System.out.print(sb);
    }
}