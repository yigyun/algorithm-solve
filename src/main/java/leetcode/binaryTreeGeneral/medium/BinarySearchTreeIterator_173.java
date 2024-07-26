package leetcode.binaryTreeGeneral.medium;

import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTreeIterator_173 {


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
    static class BSTIterator {

        Queue<Integer> que;

        public BSTIterator(TreeNode root) {
            que = new LinkedList<>();
            inorder(root);
        }

        public int next() {
            return que.poll();
        }

        public void inorder(TreeNode node){
            if(node != null){
                if(node.left != null) inorder(node.left);
                que.add(node.val);
                if(node.right != null) inorder(node.right);
            }
        }

        public boolean hasNext() {
            if(!que.isEmpty()) return true;
            return false;
        }
    }

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
}
