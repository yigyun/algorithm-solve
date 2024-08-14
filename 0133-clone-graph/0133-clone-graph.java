/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {


    static Map<Node, Node> map = new HashMap<>();

    public Node cloneGraph(Node node) {
        if(node == null) return node;
        if(map.containsKey(node)) return map.get(node);
        Node result = new Node(node.val);
        map.put(node, result);

        for(Node neighbor : node.neighbors){
            result.neighbors.add(cloneGraph(neighbor));
        }

        return result;
    }
}