package leetcode.binaryTreeGeneral.easy;

import java.util.LinkedList;
import java.util.Queue;

public class InvertBinaryTree {
    static public class TreeNode {
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
        public TreeNode invertTree(TreeNode root) {
            if(root == null) return root;

            Queue<TreeNode> que = new LinkedList<>();
            que.offer(root);

            while(!que.isEmpty()){
                TreeNode node = que.poll();
                if(node.left != null && node.right != null){
                    TreeNode temp = node.left;
                    node.left = node.right;
                    node.right = temp;
                    que.offer(node.left);
                    que.offer(node.right);
                } else if(node.left != null){
                    node.right = node.left;
                    node.left = null;
                    que.offer(node.right);
                } else if(node.right != null){
                    node.left = node.right;
                    node.right = null;
                    que.offer(node.left);
                }
            }

            return root;
        }
    }
}
