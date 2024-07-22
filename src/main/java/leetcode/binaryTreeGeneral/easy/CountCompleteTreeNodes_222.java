package leetcode.binaryTreeGeneral.easy;

import java.util.LinkedList;
import java.util.Queue;

public class CountCompleteTreeNodes_222 {

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
        public int countNodes(TreeNode root) {

            if(root == null) return 0;

            Queue<TreeNode> que = new LinkedList<>();
            que.offer(root);
            int result = 0;
            while(!que.isEmpty()){
                TreeNode node = que.poll();
                result++;
                if(node.left != null) que.offer(node.left);
                if(node.right != null) que.offer(node.right);
            }

            return result;
        }
    }
}
