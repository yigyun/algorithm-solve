import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int t = 0; t < n; t++){
            List<Character> list = new LinkedList<>();
            ListIterator<Character> lit = list.listIterator();

            for(char ch : br.readLine().toCharArray()) {
                if (ch == '<') {
                    if (lit.hasPrevious()) lit.previous();
                } else if (ch == '>') {
                    if (lit.hasNext()) lit.next();
                } else if (ch == '-') {
                    if (lit.hasPrevious()) {
                        lit.previous();
                        lit.remove();
                    }
                } else {
                    lit.add(ch);
                }
            }
            for(char ch : list){
                sb.append(ch);
            }
            sb.append('\n');
        }

        System.out.print(sb);
    }
}