package leetcode.binary_tree_BFS.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeRightSideView_199 {
     public static class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode() {}
          TreeNode(int val) { this.val = val; }
          TreeNode(int val, TreeNode left, TreeNode right) {
              this.val = val;
              this.left = left;
              this.right = right;
          }
     }
    static class Solution {
        public List<Integer> rightSideView(TreeNode root) {

            List<Integer> result = new ArrayList<>();

            if(root == null) return result;

            Queue<TreeNode> que = new LinkedList<>();
            que.offer(root);

            while(!que.isEmpty()){
                int depth = que.size();

                for(int i = 0; i < depth; i++){
                    TreeNode node = que.poll();
                    if(i == depth - 1){
                        result.add(node.val);
                    }
                    if(node.left != null) que.offer(node.left);
                    if(node.right != null) que.offer(node.right);
                }
            }

            return result;
        }
    }
}
