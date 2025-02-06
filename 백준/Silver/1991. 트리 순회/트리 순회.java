import java.util.*;
import java.io.*;

class Main{

    static StringBuilder sb;
    static int n;

    static class Node{
        String val;
        String left;
        String right;
        Node(String val){
            this.val = val;
        }
    }

    static Map<String, Node> map;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        sb = new StringBuilder();

        map = new HashMap<>();

        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String parent = st.nextToken();
            String left = st.nextToken();
            String right = st.nextToken();

            Node node = new Node(parent);
            node.left = left;
            node.right = right;
            map.put(parent, node);
        }

        preOrder("A");
        sb.append('\n');

        inorder("A");
        sb.append('\n');

        postorder("A");

        System.out.print(sb);
    }

    static void preOrder(String parent){
        Node cur = map.get(parent);
        sb.append(cur.val);
        if(!cur.left.equals(".")) preOrder(cur.left);
        if(!cur.right.equals(".")) preOrder(cur.right);
    }

    static void inorder(String parent){
        Node cur = map.get(parent);
        if(!cur.left.equals(".")) inorder(cur.left);
        sb.append(cur.val);
        if(!cur.right.equals(".")) inorder(cur.right);
    }

    static void postorder(String parent){
        Node cur = map.get(parent);
        if(!cur.left.equals(".")) postorder(cur.left);
        if(!cur.right.equals(".")) postorder(cur.right);
        sb.append(cur.val);
    }

}