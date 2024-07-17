package leetcode.binary_tree_BFS.easy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AverageOfLevelsInBinaryTree_637 {

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
        public List<Double> averageOfLevels(TreeNode root) {
            List<Double> result = new ArrayList<>();
            if(root == null) return result;

            Queue<TreeNode> que = new LinkedList<>();
            que.offer(root);

            while(!que.isEmpty()){
                int depth = que.size();
                double sum = 0;
                for(int i = 0; i < depth; i++){
                    TreeNode node = que.poll();

                    sum += (double)node.val;
                    if(node.right != null) que.offer(node.right);
                    if(node.left != null) que.offer(node.left);
                }
                result.add((double)sum / depth);
            }

            return result;
        }
    }
}
