package leetcode.binary_search_tree.easy;

public class MinimumAbsoluteDifferenceInBST {

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

        static int min;
        static int prev;
        public int getMinimumDifference(TreeNode root) {
            min = Integer.MAX_VALUE;
            prev = Integer.MAX_VALUE;

            inorder(root);

            return min;
        }

        static void inorder(TreeNode node){
            if(node != null){
                if(node.left != null){
                    inorder(node.left);
                }
                min = Math.min(min, Math.abs(node.val - prev));
                prev = node.val;
                if(node.right != null) {
                    inorder(node.right);
                }
            }
        }
    }
}
