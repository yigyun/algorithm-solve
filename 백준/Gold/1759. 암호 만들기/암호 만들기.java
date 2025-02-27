import java.util.*;
import java.io.*;

class Main{

    static int l,c;
    static char[] chs;
    static boolean[] visited;
    static StringBuilder sb;
    static Set<String> set;
    static Set<Character> mo;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();
        set = new HashSet<>();
        mo = new HashSet<>();
        mo.add('a'); mo.add('e'); mo.add('i'); mo.add('o'); mo.add('u');

        l = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        chs = new char[c];
        visited = new boolean[c];
        for(int i = 0; i < c; i++){
            chs[i] = st.nextToken().charAt(0);
        }

        Arrays.sort(chs);

        back(0, 0);

        System.out.print(sb);
    }

    static void back(int idx, int count){
        if(count == l){
            StringBuilder temp = new StringBuilder();
            int mc = 0;
            int jc = 0;
            for(int i = 0; i < c; i++){
                if(visited[i]){
                    if(mo.contains(chs[i])) mc++;
                    else jc++;
                    temp.append(chs[i]);
                }
            }

            if(!set.contains(temp.toString()) && mc >= 1 && jc >= 2){
                set.add(temp.toString());
                sb.append(temp).append('\n');
            }
            return;
        }

        for(int i = idx; i < c; i++){
            if(!visited[i]){
                visited[i] = true;
                back(i + 1, count + 1);
                visited[i] = false;
            }
        }
    }
}