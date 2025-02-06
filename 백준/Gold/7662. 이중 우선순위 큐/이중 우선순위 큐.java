import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int time = 0; time < t; time++){
            int k = Integer.parseInt(br.readLine());

            TreeMap<Integer, Integer> tree = new TreeMap<>();

            for(int i = 0; i < k; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                String op = st.nextToken();
                int num = Integer.parseInt(st.nextToken());

                if(op.equals("I")){
                    tree.put(num, tree.getOrDefault(num, 0) + 1);
                }else{
                    if(num == 1){
                        if(!tree.isEmpty()){
                            int key = tree.lastKey();
                            if(tree.get(key) == 1){
                                tree.remove(key);
                            }else{
                                tree.put(key, tree.get(key) - 1);
                            }
                        }
                    }else{
                        if(!tree.isEmpty()){
                            int key = tree.firstKey();
                            if(tree.get(key) == 1){
                                tree.remove(key);
                            }else{
                                tree.put(key, tree.get(key) - 1);
                            }
                        }
                    }
                }
            }

            if(!tree.isEmpty()){
                sb.append(tree.lastKey()).append(" ").append(tree.firstKey()).append('\n');
            }else{
                sb.append("EMPTY").append('\n');
            }
        }
        System.out.print(sb);
    }
}