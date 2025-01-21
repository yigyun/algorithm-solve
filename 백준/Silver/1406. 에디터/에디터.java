import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        List<Character> list = new LinkedList<>();
        for(char ch : st.nextToken().toCharArray()){
            list.add(ch);
        }

        int pos = list.size();
        int t = Integer.parseInt(br.readLine());
        ListIterator<Character> lit = list.listIterator();

        for(int i = 0; i < pos; i++){
            lit.next();
        }

        for(int i = 0; i < t; i++){
            st = new StringTokenizer(br.readLine());
            String op = st.nextToken();
            if(op.equals("L")){
                if(lit.hasPrevious())
                    lit.previous();
            }else if(op.equals("D")){
                if(lit.hasNext())
                    lit.next();
            }else if(op.equals("B")){
                if(lit.hasPrevious()) {
                    lit.previous();
                    lit.remove();
                }
            }else{
                lit.add(st.nextToken().charAt(0));
            }
        }

        StringBuilder sb = new StringBuilder();
        for(char ch : list){
            sb.append(ch);
        }
        System.out.print(sb);

    }


}