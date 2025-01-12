import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        List<String> list = new ArrayList<>();
        for(int i = 0; i < str.length(); i++){
            list.add(str.substring(i));
        }

        Collections.sort(list);

        StringBuilder sb = new StringBuilder();
        for(String s : list){
            sb.append(s).append('\n');
        }

        System.out.print(sb);
    }
}