import java.util.*;

// 1번 nodeinfo를 정렬한다
// 2번 List

class Solution {
    
    static class Node{
        int x;
        int y;
        int num;
        
        Node left;
        Node right;
        
        Node(int x, int y, int num){
            this.x = x;
            this.y = y;
            this.num = num;
        }
    }
    
    public int[][] solution(int[][] nodeinfo) {
        int[][] answer = new int[2][nodeinfo.length];
        
        Node[] nodes = new Node[nodeinfo.length];
        
        for(int i = 0; i < nodes.length; i++){
            nodes[i] = new Node(nodeinfo[i][0], nodeinfo[i][1], i + 1);
        }
        
        Arrays.sort(nodes, (o1, o2) -> {
            return o2.y - o1.y;
        });
        
        Node root = makeNode(nodes);
        
        List<Integer> preList = new ArrayList<>();    
        pre(root, preList);
        
        List<Integer> postList = new ArrayList<>();    
        post(root, postList);
        
        for(int i = 0; i < preList.size(); i++){
            answer[0][i] = preList.get(i);
            answer[1][i] = postList.get(i);
        }
                
        return answer;
    }
    
    static void pre(Node node, List<Integer> visited){
        if(node == null) return;
        
        visited.add(node.num);
        if(node.left != null) pre(node.left, visited);
        if(node.right != null) pre(node.right, visited);
    }
    
    static void post(Node node, List<Integer> visited){
        if(node == null) return;
        
        if(node.left != null) post(node.left, visited);
        if(node.right != null) post(node.right, visited);
        visited.add(node.num);
    }
    
    static Node makeNode(Node[] nodes){
        Node root = nodes[0];
        for(int i = 1; i < nodes.length; i++){
            insert(root, nodes[i]);
        }
        
        return root;
    }
    
    static void insert(Node root, Node node){
        if(node.x < root.x){
            if(root.left == null){
                root.left = node;
            }else{
                insert(root.left, node);
            }
        }else{
            if(root.right == null){
                root.right = node;
            }else{
                insert(root.right, node);
            }
        }
    }
}