package softeer.lv3;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class softeer13 {
    static class Node{
        int start;
        int end;
        Node(int start, int end){
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        List<Node> list = new ArrayList<>();
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            list.add(new Node(start, end));
        }

        if(list.size() == 1 || list.size() == 0){
            System.out.print(list.size());
            return;
        }

        Collections.sort(list, (o1, o2) -> {
            if(o1.start == o2.start){
                return o1.end - o2.end;
            }
            return o1.start - o2.start;
        });

        int result = 1;
        Node node = list.get(0);
        for(int i = 1; i < list.size(); i++){
            Node temp = list.get(i);
            if(temp.start >= node.end){
                result++;
                node = temp;
            }else if(temp.end < node.end){
                node = temp;
            }
        }
        System.out.print(result);
    }
}
