package leetcode.binary_search_tree.medium;

public class ValidateBinarySearchTree {

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

        private long min = Long.MIN_VALUE;

        public boolean isValidBST(TreeNode root) {
            if(root == null) return true;
            if(!isValidBST(root.left)) return false;

            if(min >= root.val) return false;

            min = root.val;

            if(!isValidBST(root.right)) return false;

            return true;
        }
    }
}
