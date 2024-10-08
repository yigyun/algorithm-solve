/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {

    public Node connect(Node root) {
        if(root == null) return root;
        
        Queue<Node> que = new LinkedList<>();
        que.offer(root);

        while(!que.isEmpty()){
            int size = que.size();
            Node nextNode = null;
            
            for(int i = 0; i < size; i++){
                Node node = que.poll();

                if(nextNode != null) nextNode.next = node;
                nextNode = node;

                if(node.left != null) que.offer(node.left);
                if(node.right != null) que.offer(node.right);
            }
        }

        return root;
    }
}