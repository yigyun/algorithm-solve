package leetcode.binaryTreeGeneral.medium;

import java.util.*;

public class BinaryTreeZigzagLevelOrderTraversal_103 {


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
        public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
            List<List<Integer>> result = new ArrayList<>();
            if(root == null) return result;

            int depth = 0;
            Queue<TreeNode> que = new LinkedList<>();
            que.offer(root);

            while(!que.isEmpty()){
                int number = que.size();
                List<Integer> list = new ArrayList<>();
                for(int i = 0; i < number; i++){
                    TreeNode temp = que.poll();
                    if(temp.left != null) que.add(temp.left);
                    if(temp.right != null) que.add(temp.right);
                    list.add(temp.val);
                }
                if(depth % 2 == 0){
                    result.add(list);
                }else{
                    Collections.reverse(list);
                    result.add(list);
                }
                depth++;
            }

            return result;
        }
    }
}
