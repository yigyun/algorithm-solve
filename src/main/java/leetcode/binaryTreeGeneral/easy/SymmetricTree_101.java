package leetcode.binaryTreeGeneral.easy;

public class SymmetricTree_101 {

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
        public boolean check(TreeNode root1,TreeNode root2){
            if(root1==null && root2==null){
                return true;
            }
            if(root1==null ||root2==null){
                return false;
            }
            if(root1.val==root2.val){
                return check(root1.left,root2.right) && check(root1.right,root2.left);
            }
            return false;
        }
        public boolean isSymmetric(TreeNode root) {
            if(root==null){
                return true;
            }
            return check(root.left,root.right);
        }
    }
}
