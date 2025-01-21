import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        List<Integer> list = new LinkedList<>();
        for(int i = 1; i <= n; i++){
            list.add(i);
        }

        ListIterator<Integer> lit = list.listIterator();

        List<Integer> result = new ArrayList<>();

        while(list.size() > 0){
            for(int i = 0; i < k; i++){
                if(lit.hasNext()) lit.next();
                else{
                    lit = list.listIterator();
                    if(lit.hasNext()) lit.next();
                }
            }
            result.add(list.get(lit.previousIndex()));
            lit.previous();
            lit.remove();
        }

        // 출력
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        for(int i = 0; i < result.size() - 1; i++){
            sb.append(result.get(i)).append(", ");
        }

        sb.append(result.get(result.size() - 1)).append(">");
        System.out.print(sb);
    }
}