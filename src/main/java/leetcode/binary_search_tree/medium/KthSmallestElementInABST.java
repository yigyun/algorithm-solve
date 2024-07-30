package leetcode.binary_search_tree.medium;

public class KthSmallestElementInABST {


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

        public int kthSmallest(TreeNode root, int k) {
            int[] result = new int[2];
            inorder(root, k, result);
            return result[0];
        }

        private void inorder(TreeNode node, int k, int[] result){

            if(node == null || result[1] >= k) return;

            if(node.left != null) inorder(node.left, k, result);
            result[1]++;
            if(result[1] == k){
                result[0] = node.val;
                return;
            }
            if(node.right != null) inorder(node.right, k, result);
        }

    }
}
