import java.util.*;
import java.io.*;

class Main{

    public static class Number{
        int count;
        int num;
        int order; // 순서
        Number(int count, int num, int order){
            this.count = count;
            this.num = num;
            this.order = order;
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        List<Number> list = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        Map<Integer, Number> map = new HashMap<>();
        int order = 1;

        for(int i = 0; i < n; i++){
            int num = Integer.parseInt(st.nextToken());
            if(!map.containsKey(num)){
                map.put(num, new Number(1, num, order++));
            }else{
                Number temp = map.get(num);
                temp.count++;
            }
        }

        for(int temp : map.keySet()){
            list.add(map.get(temp));
        }

        Collections.sort(list, (o1, o2) -> {
            if(o1.count == o2.count){
                return o1.order - o2.order;
            } else{
                return o2.count - o1.count;
            }
        });

        for(Number temp : list){
            for(int i = 0; i < temp.count; i++){
                sb.append(temp.num + " ");
            }
        }

        System.out.println(sb);

    }
}