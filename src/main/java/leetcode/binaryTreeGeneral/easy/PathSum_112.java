package leetcode.binaryTreeGeneral.easy;

public class PathSum_112 {

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

        static boolean check;
        static int num;

        public boolean hasPathSum(TreeNode root, int targetSum) {
            if(root == null) return false;
            num = targetSum;
            check = false;
            preorder(root, 0);

            return check;
        }

        static void preorder(TreeNode node, int sum){
            if(node != null){
                sum += node.val;
                if(node.left != null) preorder(node.left, sum);
                if(node.right != null) preorder(node.right, sum);

                if(node.left == null && node.right == null){
                    if(sum == num){
                        check = true;
                    }
                }
            }
        }
    }
}
