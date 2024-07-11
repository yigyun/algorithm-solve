package leetcode.binaryTreeGeneral.easy;

public class MaximumDepthOfBinaryTree_104 {



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

    static class name {

        static int max;

        public int maxDepth(TreeNode root) {
            if(root == null) return 0;
            max = 0;
            dfs(root, 1);
            return max;
        }
        static void dfs(TreeNode node, int depth){
            if(node.left == null && node.right == null) {
                max = Math.max(max, depth);
                return;
            }

            if(node.left != null) dfs(node.left, depth + 1);
            if(node.right != null) dfs(node.right, depth + 1);
        }
    }
}
